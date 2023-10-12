package com.example.schoolmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.schoolmanagementsystem.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository <Teacher, Integer> {
    
}
