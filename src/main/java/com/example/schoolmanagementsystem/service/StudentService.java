package com.example.schoolmanagementsystem.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.schoolmanagementsystem.FileStorage;
import com.example.schoolmanagementsystem.entities.Student;
import com.example.schoolmanagementsystem.repositories.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    private final Path rootLocation;

    // location where the upload is to be done and from the file will be downloaded
    public StudentService(FileStorage properties) {
        this.rootLocation = Paths.get(properties.getUploadDir());

        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Could not create the directory for upload and download");
        }
    }

    public String storeFile(Integer id, MultipartFile file) {
        // 1. File is coming in the request which we need
        // to add in the uploads
        Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename()));

        try {
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Could not save the file");
        }

        // 2. Create the URL that will be used to download
        String uploadedFileUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/students/download/")
                .path(file.getOriginalFilename())
                .toUriString();

        Student student = this.repository.findById(id).get();
        student.setId(id);
        student.setStudentImage(uploadedFileUrl);
        this.repository.save(student);
        return "File Uploaded Successfully";
    }

    public Resource downloadFile(String filename) {
        Path file = rootLocation.resolve(filename);

        try {
            Resource resource = new UrlResource(file.toUri());

            return resource;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Could not download the file");
        }
    }
}
