package com.projects.backend.rutube2.converter;

import com.projects.backend.rutube2.dto.UserDto;
import com.projects.backend.rutube2.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {

    @Override
    public UserDto convert(final User source) {
        return new UserDto(
                source.getId(),
                source.getName(),
                source.getEmail(),
                source.getDescription(),
                source.getAvatarPath()
        );
    }
}
