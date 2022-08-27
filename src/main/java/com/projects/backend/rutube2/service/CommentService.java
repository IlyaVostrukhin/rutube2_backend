package com.projects.backend.rutube2.service;

import com.projects.backend.rutube2.dto.CommentDto;
import com.projects.backend.rutube2.entity.Comment;
import com.projects.backend.rutube2.repo.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final VideoService videoService;
    private final UserService userService;

    public List<Comment> getCommentsByVideoId(Long videoId) {
        return commentRepository.findByVideoId(videoId);
    }

    public Comment createComment(Long userId, CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setMessage(commentDto.getMessage());

        comment.setVideo(videoService.getById(commentDto.getVideo().getId()));
        comment.setUser(userService.getById(userId));

        return commentRepository.save(comment);
    }
}
