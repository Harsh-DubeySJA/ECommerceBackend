package com.ecommerce.Microservice.cart.service;

import com.ecommerce.Microservice.cart.dao.CartRepository;
import com.ecommerce.Microservice.cart.model.UserCart;
import com.ecommerce.Microservice.user.model.User;
import com.ecommerce.Microservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserService userService;

    @Autowired
    public CartService(CartRepository cartRepository, UserService userService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
    }

    private void userExists(Long userId) {
        if (userService.getUserByUserId(userId) == null) {
            userService.createGuestUser();
        }
    }

    public ResponseEntity<UserCart> getUserCartItems(Long userId) {
        try {
            userExists(userId);
            Optional<UserCart> userCart = cartRepository.findById(userId);
            if (userCart.isPresent())
                return new ResponseEntity<>(userCart.get(), HttpStatus.OK);
            else
                throw new RuntimeException("Cart does not exists");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Optional.of(new UserCart()).get(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addItems(Long userId, Long imageId) {
        try {
            userExists(userId);
            Optional<UserCart> userCart = cartRepository.findById(userId);
            if (userCart.isPresent()) {
                userCart.get().addItem(imageId);
                cartRepository.save(userCart.get());
                return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
            } else {
                throw new RuntimeException("Product could not be added to the Cart.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("failure", HttpStatus.BAD_REQUEST);
        }
    }
}
