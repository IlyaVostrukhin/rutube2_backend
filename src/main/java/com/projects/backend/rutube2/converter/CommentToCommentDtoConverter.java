package com.projects.backend.rutube2.converter;

import com.projects.backend.rutube2.dto.CommentDto;
import com.projects.backend.rutube2.entity.Comment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommentToCommentDtoConverter implements Converter<Comment, CommentDto> {

    @Override
    public CommentDto convert(Comment source) {
        return new CommentDto(
                source.getId(),
                source.getCreatedDate(),
                source.getMessage()
        );
    }

}
