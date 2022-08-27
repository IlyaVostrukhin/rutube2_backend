package com.projects.backend.rutube2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    public UserDto(Long id, String name, String email, String description, String avatarPath) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
        this.avatarPath = avatarPath;
    }

    private Long id;
    private String name;
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String description;
    private String avatarPath;

}
