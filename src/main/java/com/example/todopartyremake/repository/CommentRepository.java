package com.example.todopartyremake.repository;

import com.example.todopartyremake.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
