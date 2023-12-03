package com.example.todopartyremake.dto;

import com.example.todopartyremake.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto extends CommonResponseDto{
    private String Content;
    private LocalDateTime createdAt;

    public CommentResponseDto(Comment comment) {
        this.Content = comment.getCotent();
        this.createdAt = comment.getCreatedAt();
    }
}