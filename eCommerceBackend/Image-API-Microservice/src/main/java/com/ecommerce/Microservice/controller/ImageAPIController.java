package com.ecommerce.Microservice.controller;

import com.ecommerce.Microservice.model.ImageAPI;
import com.ecommerce.Microservice.service.ImageAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequestMapping("image")
@EnableWebMvc
@CrossOrigin
public class ImageAPIController {

    private final ImageAPIService imageAPIService;

    @Autowired
    public ImageAPIController(ImageAPIService imageAPIService) {
        this.imageAPIService = imageAPIService;
    }

    @GetMapping("cards")
    public ResponseEntity<List<ImageAPI>> getAll() {
        return imageAPIService.getAll();
    }

    @PostMapping("add")
    public ResponseEntity<String> create(@RequestParam String imageLink, @RequestParam String imageName, @RequestParam String imageDescription) {
        System.out.println(imageLink + imageName + imageDescription);
        return imageAPIService.create(imageLink, imageName, imageDescription);
    }
}
