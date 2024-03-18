package com.ecommerce.Microservice.user.service;

import com.ecommerce.Microservice.user.dao.UserRepository;
import com.ecommerce.Microservice.user.exception.UserNotFoundException;
import com.ecommerce.Microservice.user.guest.model.GuestUser;
import com.ecommerce.Microservice.user.guest.service.GuestUserService;
import com.ecommerce.Microservice.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final GuestUserService guestUserService;

    @Autowired
    public UserService(UserRepository userRepository, GuestUserService guestUserService) {
        this.userRepository = userRepository;
        this.guestUserService = guestUserService;
    }

    public User getUserByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent())
            return userOptional.get();
        else
            throw new UserNotFoundException();
    }

    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public void createGuestUser() {
        guestUserService.createGuestUser();
    }

    public ResponseEntity<Optional<User>> getUserByUserIdForWeb(Long userId) {
        try {
            return new ResponseEntity<>(userRepository.findById(userId), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
