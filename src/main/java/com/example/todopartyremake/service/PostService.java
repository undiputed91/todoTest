package com.example.todopartyremake.service;

import com.example.todopartyremake.dto.PostRequestDto;
import com.example.todopartyremake.dto.PostResponseDto;
import com.example.todopartyremake.entity.Post;
import com.example.todopartyremake.repository.PostRepository;
import com.example.todopartyremake.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<PostResponseDto> getPostList() {

        List<Post> postList = postRepository.findAll();
        List<PostResponseDto> response = new ArrayList<>();
        for(int i = 0; i< postList.size();i++){
            response.add(new PostResponseDto(postList.get(i)));
        }
        return response;
    }

    public PostResponseDto getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 id 게시물이 없습니다."));
        return new PostResponseDto(post);
    }
}
