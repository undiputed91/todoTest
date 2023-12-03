package com.example.todopartyremake.dto;

import com.example.todopartyremake.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto extends CommonResponseDto{
    private Long id;
    private String title;
    private String contents;
    private Boolean isCompleted;
    private LocalDateTime createdAt;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.isCompleted = post.getIsCompleted();
        this.createdAt = post.getCreatedAt();
    }
}
