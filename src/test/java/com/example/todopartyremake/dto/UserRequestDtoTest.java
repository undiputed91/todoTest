package com.example.todopartyremake.dto;

import com.example.todopartyremake.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRequestDtoTest {
    @Test
    @DisplayName("유효성테스트")
    public void validTest1(){
        //given
       UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setUsername("ABC");
        userRequestDto.setPassword("1");
        //when then
        assertNotNull(userRequestDto.getUsername());
        assertNotNull(userRequestDto.getPassword());

    }
}