package com.example.schoolmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SchoolmanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolmanagementsystemApplication.class, args);
	}

}
