package com.example.todopartyremake.entity;

import com.example.todopartyremake.dto.PostRequestDto;
import com.example.todopartyremake.security.UserDetailsImpl;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor
public class Post extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String contents;

    public Post(PostRequestDto postRequestDto, UserDetailsImpl userDetailsImpl) {
        this.title = postRequestDto.getTitle();
        this.contents = postRequestDto.getContents();
    }
}
