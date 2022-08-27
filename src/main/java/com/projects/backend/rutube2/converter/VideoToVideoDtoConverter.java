package com.projects.backend.rutube2.converter;

import com.projects.backend.rutube2.dto.VideoDto;
import com.projects.backend.rutube2.entity.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VideoToVideoDtoConverter implements Converter<Video, VideoDto> {

    @Override
    public VideoDto convert(Video source) {
        return new VideoDto(
                source.getId(),
                source.getUpdatedDate(),
                source.getName(),
                source.isPublic(),
                source.getViews(),
                source.getLikes(),
                source.getDuration(),
                source.getDescription(),
                source.getVideoPath(),
                source.getThumbnailPath()
        );
    }

}
