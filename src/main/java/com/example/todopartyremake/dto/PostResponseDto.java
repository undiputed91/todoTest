package com.example.todopartyremake.dto;

import com.example.todopartyremake.entity.Post;

import java.time.LocalDateTime;

public class PostResponseDto extends CommonResponseDto{
    private Long id;
    private String title;
    private String contents;
    private LocalDateTime createdAt;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.createdAt = post.getCreatedAt();
    }
}
