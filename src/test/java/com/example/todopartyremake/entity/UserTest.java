package com.example.todopartyremake.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    @DisplayName("유저 객체 생성 테스트-pojo테스트..?")
    public void test1(){
        //given
        User user = new User();
        user.setId(10L);
        user.setUsername("user10");
        user.setPassword("12345678");
        //when
        //then
        assertEquals(10L, user.getId().longValue());
        assertEquals("user10", user.getUsername());
        assertEquals("12345678", user.getPassword());
    }
}