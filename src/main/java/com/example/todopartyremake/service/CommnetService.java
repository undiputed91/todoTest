package com.example.todopartyremake.service;

import com.example.todopartyremake.dto.CommentRequestDto;
import com.example.todopartyremake.dto.CommentResponseDto;
import com.example.todopartyremake.entity.Comment;
import com.example.todopartyremake.entity.Post;
import com.example.todopartyremake.repository.CommentRepository;
import com.example.todopartyremake.repository.PostRepository;
import com.example.todopartyremake.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommnetService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    public CommentResponseDto postComment(Long id, CommentRequestDto commentRequestDto, UserDetailsImpl userDetails) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(("해당 게시글이 없습니다.")));
        if (commentRequestDto.getContents() == null) {
            throw new IllegalArgumentException("내용을 입력하세요");
        }
        Comment comment = new Comment(post, commentRequestDto, userDetails);
        Comment saveComment = commentRepository.save(comment);
        CommentResponseDto commentResponseDto = new CommentResponseDto(saveComment);
        return commentResponseDto;
    }
}
