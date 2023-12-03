package com.example.todopartyremake.service;

import com.example.todopartyremake.dto.PostRequestDto;
import com.example.todopartyremake.dto.PostResponseDto;
import com.example.todopartyremake.entity.Post;
import com.example.todopartyremake.repository.PostRepository;
import com.example.todopartyremake.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostResponseDto createPost(PostRequestDto postRequestDto, UserDetailsImpl userDetailsImpl) {
        Post post = new Post(postRequestDto,userDetailsImpl);
        Post savePost = postRepository.save(post);
        PostResponseDto postResponseDto = new PostResponseDto(savePost);
        return postResponseDto;
    }
}
