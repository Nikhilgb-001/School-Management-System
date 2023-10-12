package com.example.schoolmanagementsystem.entities;

import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    // @OneToOne
    // @JoinColumn(name = "parent_id")
    // private Parent parents;

    // @ManyToMany
    // @JoinTable(
    //         name = "Student_Subject",
    //         joinColumns = @JoinColumn(name = "Student_ID"),
    //         inverseJoinColumns = @JoinColumn(name = "Subject_ID")
    // )
    // private List<Subject> subjects;

    private String studentImage;
}
