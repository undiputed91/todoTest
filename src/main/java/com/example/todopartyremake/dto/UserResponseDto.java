package com.example.todopartyremake.dto;

import lombok.Getter;

@Getter
public class UserResponseDto extends CommonResponseDto {
    private String username;
    private String password;

}