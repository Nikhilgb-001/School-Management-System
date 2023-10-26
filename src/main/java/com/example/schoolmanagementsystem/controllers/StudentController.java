package com.example.schoolmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.schoolmanagementsystem.service.StudentService;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PutMapping("/students/{id}/upload")
    public ResponseEntity<?> upload(@PathVariable Integer id, @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(studentService.storeFile(id, file));
    }

    @GetMapping("/students/download/{filename}")
    public ResponseEntity<?> download(@PathVariable String filename) {
        Resource resource = this.studentService.downloadFile(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + filename + "\"")
                .body(resource);
    }
}