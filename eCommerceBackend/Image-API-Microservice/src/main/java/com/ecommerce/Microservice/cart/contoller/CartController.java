package com.ecommerce.Microservice.cart.contoller;

import com.ecommerce.Microservice.cart.model.UserCart;
import com.ecommerce.Microservice.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("allItems")
    public ResponseEntity<UserCart> getAllCartItems(@RequestParam Long userId) {
        return cartService.getUserCartItems(userId);
    }

    @PostMapping("addItem")
    public ResponseEntity<String> addItems(@RequestParam Long userId, @RequestParam Long imageId) {
        return cartService.addItems(userId, imageId);
    }
}
