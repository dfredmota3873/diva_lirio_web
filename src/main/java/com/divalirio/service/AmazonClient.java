package com.divalirio.service;

import com.amazonaws.services.s3.AmazonS3;
import com.divalirio.model.DivaLirioImage;
import com.divalirio.repository.DivaLirioImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
import java.util.Optional;

import static org.apache.http.entity.ContentType.*;

import com.divalirio.api.config.BucketName;

@Service
@RequiredArgsConstructor
public class AmazonClient {

    private AmazonS3 s3client;

    @Value("${amazonProperties.endpointUrl}")
    private String endpointUrl;
    @Value("${amazonProperties.bucketName}")
    private String bucketName;
    @Value("${amazonProperties.accessKey}")
    private String accessKey;
    @Value("${amazonProperties.secretKey}")
    private String secretKey;

    private final FileStorageLirio fileStore;
    private final DivaLirioImageRepository repository;


    public DivaLirioImage saveTodo(String title, String description, MultipartFile file) {
        //check if the file is empty
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }
        //Check if the file is an image
        if (!Arrays.asList(IMAGE_PNG.getMimeType(),
                IMAGE_BMP.getMimeType(),
                IMAGE_GIF.getMimeType(),
                IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("FIle uploaded is not an image");
        }


        //get file metadata
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        //Save Image in S3 and then save Todo in the database
        String path = String.format("%s/%s", BucketName.TODO_IMAGE.getBucketName(), UUID.randomUUID());
        String fileName = String.format("%s", file.getOriginalFilename());
        try {
            fileStore.upload(path, fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to upload file", e);
        }
        DivaLirioImage todo = DivaLirioImage.builder()
                .description(description)
                .title(title)
                .imagePath(path)
                .imageFileName(fileName)
                .build();
        //repository.save(todo);
        return null;// repository.findByTitle(todo.getTitle());
    }


    public byte[] downloadTodoImage(Long id) {
        DivaLirioImage todo = repository.findById(id).get();
        return fileStore.download(todo.getImagePath(), todo.getImageFileName());
    }


    public List<DivaLirioImage> getAllTodos() {
        List<DivaLirioImage> todos = new ArrayList<>();
        repository.findAll().forEach(todos::add);
        return todos;
    }

}
