package com.example.todopartyremake.entity;


import com.example.todopartyremake.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@NoArgsConstructor
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post>postList = new ArrayList<>();

    public User (UserRequestDto userRequestDto,String encodedPassword){
        this.username = userRequestDto.getUsername();
        this.password = encodedPassword;
    }


}