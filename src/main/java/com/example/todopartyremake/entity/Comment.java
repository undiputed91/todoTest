package com.example.todopartyremake.entity;

import com.example.todopartyremake.dto.CommentRequestDto;
import com.example.todopartyremake.security.UserDetailsImpl;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cotent;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(Post post, CommentRequestDto commentRequesDto, UserDetailsImpl userDetails) {
        this.cotent = commentRequesDto.getContents();
        this.user = userDetails.getUser();
        this.post = post;
    }
}
