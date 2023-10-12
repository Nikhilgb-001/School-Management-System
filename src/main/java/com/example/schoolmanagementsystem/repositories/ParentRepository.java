package com.example.schoolmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.schoolmanagementsystem.entities.Parent;

@Repository
public interface ParentRepository extends JpaRepository <Parent, Integer>{
    
}
