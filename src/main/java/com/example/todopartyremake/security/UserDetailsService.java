package com.example.todopartyremake.security;

import com.example.todopartyremake.entity.User;
import com.example.todopartyremake.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsImpl getUserDetails(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 유저가 없습니다."));
        return new UserDetailsImpl(user);
    }

}