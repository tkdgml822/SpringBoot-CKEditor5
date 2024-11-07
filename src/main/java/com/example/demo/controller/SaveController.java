package com.example.demo.controller;

import com.example.demo.dto.SaveDTO;
import com.example.demo.entity.ContentEntity;
import com.example.demo.service.ContentService;
import com.example.demo.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@Slf4j
public class SaveController {

    private ContentService contentService;
    private ImageService imageService;

    // Controller - Service 연결
    @Autowired
    public SaveController(ContentService contentService, ImageService imageService) {
        this.contentService = contentService;
        this.imageService = imageService;
    }

    @PostMapping("/save")
    public String saveLogic(SaveDTO saveDTO) throws IOException {
        contentService.saveContent(saveDTO);

        return "redirect:/";
    }


    @PostMapping("/save/{id}")
    public String updateLogic(SaveDTO saveDTO, @PathVariable("id") String id) {
        contentService.updateOneContent(saveDTO, id);

        return "redirect:/content/" + id;
    }
}
