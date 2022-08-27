package com.projects.backend.rutube2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    public CommentDto(Long id, Date createdDate, String message) {
        this.id = id;
        this.createdDate = createdDate;
        this.message = message;
    }

    private Long id;
    private Date createdDate;
    private String message;
    private UserDto user;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private VideoDto video;

}
