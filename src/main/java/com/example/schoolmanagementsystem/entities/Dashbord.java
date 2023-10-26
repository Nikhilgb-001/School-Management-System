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
public class Dashbord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String name;

    private Integer fees;

    private String remarks;

    private Integer marks;

    private String password;

    @OneToOne
    @JoinColumn(name = "parent_Id")
    private Parent parent;

}

// http://localhost:8080/dashbords/2/parent url-1
// http://localhost:8080/parents/2 url-2