package com.example.schoolmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schoolmanagementsystem.entities.Subject;

public interface SubjectRepository extends JpaRepository <Subject, Integer> {
    
}
