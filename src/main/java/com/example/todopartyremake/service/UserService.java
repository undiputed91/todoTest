package com.example.todopartyremake.service;

import com.example.todopartyremake.dto.UserRequestDto;
import com.example.todopartyremake.entity.User;
import com.example.todopartyremake.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signup(UserRequestDto userRequestDto) {
        if(userRepository.findByUsername(userRequestDto.getUsername()).isPresent()){
            throw new IllegalArgumentException("이미 존재하는 유저입니다.");
        }
        User user = new User(userRequestDto);
        userRepository.save(user);
    }
}