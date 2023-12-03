package com.example.todopartyremake.controller;

import com.example.todopartyremake.dto.CommonResponseDto;
import com.example.todopartyremake.dto.PostRequestDto;
import com.example.todopartyremake.dto.PostResponseDto;
import com.example.todopartyremake.security.UserDetailsImpl;
import com.example.todopartyremake.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<CommonResponseDto> createPost(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl){
        PostResponseDto postResponseDto = postService.createPost(postRequestDto,userDetailsImpl);
        return ResponseEntity.status(201).body(new CommonResponseDto("게시글 작성완료", HttpStatus.CREATED.value()));
    }
    @GetMapping
    public List<PostResponseDto> getPostList(){
        return postService.getPostList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponseDto> getPost(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(postService.getPost(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new CommonResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CommonResponseDto> updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        try {
            postService.updatePost(id,requestDto,userDetails);
            return ResponseEntity.ok().body(new CommonResponseDto("수정완료",HttpStatus.OK.value()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new CommonResponseDto(e.getMessage(),HttpStatus.BAD_REQUEST.value()));
        }
    }
    @PatchMapping("/{id}/complete")
    public ResponseEntity<CommonResponseDto>postComplete(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        try {
            postService.postComplete(id,userDetails);
            return ResponseEntity.ok().body(new CommonResponseDto("완료!",HttpStatus.OK.value()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new CommonResponseDto(e.getMessage(),HttpStatus.BAD_REQUEST.value()));
        }
    }
}
