package com.projects.backend.rutube2.controller;

import com.projects.backend.rutube2.dto.VideoDto;
import com.projects.backend.rutube2.entity.Video;
import com.projects.backend.rutube2.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @PostMapping("/{id}")
    public ResponseEntity<VideoDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(videoService.getVideoDtoById(id));
    }

    @PostMapping()
    public ResponseEntity<List<Video>> search(@RequestParam String searchTerm) {
        return ResponseEntity.ok(videoService.getVideoByName(searchTerm));
    }

    @PostMapping("/popular")
    public ResponseEntity<Video> getMostPopular() {
        return ResponseEntity.ok(videoService.getMostPopular());
    }

    //ToDo: после авторизации -> метод только для авторизованных + из сессии брать id пользователя
    @PostMapping("/create")
    public ResponseEntity<Long> createVideo(@RequestBody Long userId) {
        return ResponseEntity.ok(videoService.createEmpty(userId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Video> update(@PathVariable("id") Long id, @RequestBody VideoDto videoDto) {
        return ResponseEntity.ok(videoService.update(id, videoDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long videoId) {
        videoService.delete(videoId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update-views/{id}")
    public ResponseEntity<Video> updateViews(@PathVariable("id") Long videoId) {
        return ResponseEntity.ok(videoService.updateViews(videoId));
    }

    @PutMapping("/update-likes/{id}")
    public ResponseEntity<Video> updateLikes(@PathVariable("id") Long videoId) {
        return ResponseEntity.ok(videoService.updateLikes(videoId));
    }

}
