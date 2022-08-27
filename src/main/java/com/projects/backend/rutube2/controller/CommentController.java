package com.projects.backend.rutube2.controller;

import com.projects.backend.rutube2.dto.CommentDto;
import com.projects.backend.rutube2.entity.Comment;
import com.projects.backend.rutube2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{id}")
    public ResponseEntity<Comment> createComment(@PathVariable("id") Long userId, @RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.createComment(userId, commentDto));
    }
}
