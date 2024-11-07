package com.example.demo.controller;

import com.example.demo.dto.SaveDTO;
import com.example.demo.service.ContentService;
import com.example.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ImageController {

    private final ImageService imageService;
    private final ContentService contentService;

    @Autowired
    public ImageController(ImageService imageService, ContentService contentService) {
        this.imageService = imageService;
        this.contentService = contentService;
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        String imageUrl = imageService.upload(file);
        return ResponseEntity.ok(imageUrl);
    }
}
