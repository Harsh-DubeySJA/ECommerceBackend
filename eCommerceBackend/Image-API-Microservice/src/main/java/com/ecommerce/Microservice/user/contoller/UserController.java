package com.ecommerce.Microservice.user.contoller;

import com.ecommerce.Microservice.user.model.User;
import com.ecommerce.Microservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("get")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }
}
