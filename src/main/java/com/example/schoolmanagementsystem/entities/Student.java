package com.example.schoolmanagementsystem.entities;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private int age;
    private String grade;
    private String className;
    private String address;
    private String fees;
    private String email;

    // Relationship and Mapping 
    @OneToOne
    @JoinColumn(name = "parent_id")
    private Parent parents;

    private String studentImage;
}


// http://localhost:8080/students/1/parents url-1
// http://localhost:8080/parents/4 url-2

// http://localhost:8080/students/2/upload file upoload url