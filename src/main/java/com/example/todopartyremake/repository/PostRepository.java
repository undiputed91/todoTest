package com.example.todopartyremake.repository;

import com.example.todopartyremake.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
