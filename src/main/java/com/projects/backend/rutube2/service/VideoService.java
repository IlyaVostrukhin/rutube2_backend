package com.projects.backend.rutube2.service;

import com.projects.backend.rutube2.dto.CommentDto;
import com.projects.backend.rutube2.dto.UserDto;
import com.projects.backend.rutube2.dto.VideoDto;
import com.projects.backend.rutube2.entity.Video;
import com.projects.backend.rutube2.repo.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;
    private final UserService userService;
    private final ConversionService conversionService;

    public VideoDto getVideoDtoById(Long id) {
        Video video = videoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Video with id=" + id + " not found!"));

        return createDto(video);
    }

    public Video getById(Long id) {
        return videoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Video with id=" + id + " not found!"));
    }

    public Video update(Long id, VideoDto dto) {
        Video video = videoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Video with id=" + id + " not found!"));

        video.setName(dto.getName());
        video.setPublic(dto.isPublic());
        video.setDescription(dto.getDescription());
        video.setVideoPath(dto.getVideoPath());
        video.setThumbnailPath(dto.getThumbnailPath());

        return videoRepository.save(video);
    }

    public List<Video> getVideoByName(String name) {
        return videoRepository.findPublicByName(name);
    }

    public Video getMostPopular() {
        return videoRepository.findMostPopular();
    }

    public Long createEmpty(Long userId) {
        Video video = new Video();
        video.setName("");
        video.setUser(userService.getById(userId));
        return videoRepository.save(video).getId();
    }

    public void delete(Long videoId) {
        videoRepository.deleteById(videoId);
    }

    public Video updateViews(Long videoId) {
        Video video = videoRepository.findById(videoId).orElseThrow(() -> new EntityNotFoundException("Video with id=" + videoId + " not found!"));
        video.setViews(video.getViews() + 1);
        return videoRepository.save(video);
    }

    //TODO: Привязать лайк юзера к конкретному видео (video_likes?)
    public Video updateLikes(Long videoId) {
        Video video = videoRepository.findById(videoId).orElseThrow(() -> new EntityNotFoundException("Video with id=" + videoId + " not found!"));
        video.setLikes(video.getLikes() + 1);
        return videoRepository.save(video);
    }

    private VideoDto createDto(Video video) {
        VideoDto result = conversionService.convert(video, VideoDto.class);
        if (result != null) {
            result.setUser(conversionService.convert(video.getUser(), UserDto.class));
            result.setComments(video.getComments().stream().map(c -> {
                CommentDto dto = conversionService.convert(c, CommentDto.class);
                Objects.requireNonNull(dto).setUser(conversionService.convert(c.getUser(), UserDto.class));
                return dto;
            }).sorted(Comparator.comparing(CommentDto::getCreatedDate)).collect(Collectors.toList()));
        }

        return result;
    }

}
