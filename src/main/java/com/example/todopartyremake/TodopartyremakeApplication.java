package com.example.todopartyremake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TodopartyremakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodopartyremakeApplication.class, args);
	}

}
