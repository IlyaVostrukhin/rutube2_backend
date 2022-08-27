package com.projects.backend.rutube2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideoDto {

    public VideoDto(String name, boolean isPublic, String description, String videoPath, String thumbnailPath) {
        this.name = name;
        this.isPublic = isPublic;
        this.description = description;
        this.videoPath = videoPath;
        this.thumbnailPath = thumbnailPath;
    }

    public VideoDto(Long id, Date updatedDate, String name, boolean isPublic, Integer views, Integer likes, String duration, String description, String videoPath, String thumbnailPath) {
        this.id = id;
        this.updatedDate = updatedDate;
        this.name = name;
        this.isPublic = isPublic;
        this.views = views;
        this.likes = likes;
        this.duration = duration;
        this.description = description;
        this.videoPath = videoPath;
        this.thumbnailPath = thumbnailPath;
    }

    private Long id;
    private Date updatedDate;
    private String name;
    private boolean isPublic;
    private Integer views;
    private Integer likes;
    private String duration;
    private String description;
    private String videoPath;
    private String thumbnailPath;
    private UserDto user;
    private List<CommentDto> comments;

}
