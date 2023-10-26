package com.example.schoolmanagementsystem.entities;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private int age;
    private String subjectsHandeled;
    private String email;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subjects;
}

// http://localhost:8080/teachers/2/subjects request is put
// http://localhost:8080/subjects/1
