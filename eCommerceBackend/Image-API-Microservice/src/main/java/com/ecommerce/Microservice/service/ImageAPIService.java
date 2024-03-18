package com.ecommerce.Microservice.service;

import com.ecommerce.Microservice.dao.ImageAPIRepository;
import com.ecommerce.Microservice.model.ImageAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ImageAPIService {

    private final ImageAPIRepository imageAPIRepository;

    @Autowired
    public ImageAPIService(ImageAPIRepository imageAPIRepository) {
        this.imageAPIRepository = imageAPIRepository;
    }

    public ResponseEntity<List<ImageAPI>> getAll() {
        try {
            List<ImageAPI> dataResponse = imageAPIRepository.findAll();
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(List.of(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> create(String imageLink, String imageName, String imageDescription) {
        try {
            ImageAPI image = new ImageAPI(imageLink, imageName, imageDescription);
            imageAPIRepository.save(image);
            return new ResponseEntity<>("Successful", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failure", HttpStatus.BAD_REQUEST);
        }
    }

    public ImageAPI getByImageId(Long imageId) {
        Optional<ImageAPI> imageAPI = imageAPIRepository.findById(imageId);
        if (imageAPI.isPresent()) {
            return imageAPI.get();
        } else {
            throw new NullPointerException("Image Not Found in the Database");
        }
    }
}
