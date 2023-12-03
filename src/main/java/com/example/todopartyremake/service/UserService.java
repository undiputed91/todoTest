package com.example.todopartyremake.service;

import com.example.todopartyremake.dto.UserRequestDto;
import com.example.todopartyremake.entity.User;
import com.example.todopartyremake.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void signup(UserRequestDto userRequestDto) {
        if(userRepository.findByUsername(userRequestDto.getUsername()).isPresent()){
            throw new IllegalArgumentException("이미 존재하는 유저입니다.");
        }
        String encededPassword = passwordEncoder.encode(userRequestDto.getPassword());
        User user = new User(userRequestDto,encededPassword);
        userRepository.save(user);
    }
    public void login(UserRequestDto userRequestDto) {
        String username = userRequestDto.getUsername();
        String password = userRequestDto.getPassword();
        //db에 이름 여부 파악
        User user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("해당이름이 없습니다."));
        //비밀번호 일치
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}