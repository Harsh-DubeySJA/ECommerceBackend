package com.ecommerce.Oauth2Login.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("purchase")
public class PaymentController {

    /**
     * Purchase from eCommerce Website requires Verified User Login
     */
    @GetMapping("payment")
    public ResponseEntity<String> paymentGateway(Long userId) {
        try {
            String confirmationMessage = userId + " ,kindly complete your purchase";
            return new ResponseEntity<>(confirmationMessage, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Payment Gateway is not accessible. Please Loginn again", HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("cart")
    public ResponseEntity<String> cart(Long userId) {
        try {
            return new ResponseEntity<>("User ID: " + userId + " does not contain any item.", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Invalid Request", HttpStatus.BAD_REQUEST);
        }
    }

}
