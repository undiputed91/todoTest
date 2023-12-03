package com.example.todopartyremake.controller;


import com.example.todopartyremake.dto.CommentRequestDto;
import com.example.todopartyremake.dto.CommentResponseDto;
import com.example.todopartyremake.dto.CommonResponseDto;
import com.example.todopartyremake.security.UserDetailsImpl;
import com.example.todopartyremake.service.CommnetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class CommentController {
    private final CommnetService commnetService;

    @PostMapping("/{id}/comments")
    public  ResponseEntity<CommonResponseDto>postComment(@PathVariable Long id,@RequestBody CommentRequestDto commentRequestDto,@AuthenticationPrincipal UserDetailsImpl userDetails){
        try {
            CommentResponseDto commentResponseDto = commnetService.postComment(id,commentRequestDto,userDetails);
            return ResponseEntity.ok().body(commentResponseDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new CommonResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        }
    }
    @PatchMapping("/{id}/comments/{commentId}")
    public ResponseEntity<CommonResponseDto> modifyComment(@PathVariable Long id,@PathVariable Long commentId, @RequestBody CommentRequestDto commentRequestDto,@AuthenticationPrincipal UserDetailsImpl user){
        try {
            commnetService.modifyComment(id,commentId,commentRequestDto,user);
            return ResponseEntity.ok().body(new CommonResponseDto("수정완료", HttpStatus.OK.value()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new CommonResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        }
    }

}
