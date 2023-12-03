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
    @Column
    private Boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post(PostRequestDto postRequestDto, UserDetailsImpl userDetailsImpl) {
        this.title = postRequestDto.getTitle();
        this.contents = postRequestDto.getContents();
        this.user = userDetailsImpl.getUser();
        this.isCompleted = false;
    }

    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void clickCompleted(){
        this.isCompleted = true;
    }
}
