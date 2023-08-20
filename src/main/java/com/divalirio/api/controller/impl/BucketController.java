package com.divalirio.api.controller.impl;

import com.divalirio.model.DivaLirioImage;
import com.divalirio.service.AmazonClient;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/image")
@AllArgsConstructor
@CrossOrigin("*")
public class BucketController {
    AmazonClient service;

    @GetMapping
    public ResponseEntity<List<DivaLirioImage>> getTodos() {
        return new ResponseEntity<>(service.getAllTodos(), HttpStatus.OK);
    }

    @PostMapping(
            path = "",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DivaLirioImage> saveTodo(@RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(service.saveTodo("test", "test", file), HttpStatus.OK);
    }

    @GetMapping(value = "{id}/image/download")
    public byte[] downloadTodoImage(@PathVariable("id") Long id) {
        return service.downloadTodoImage(id);
    }
}
