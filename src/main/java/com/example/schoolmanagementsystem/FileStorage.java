package com.example.schoolmanagementsystem;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "file")
public class FileStorage {
    private String uploadDir;
}
