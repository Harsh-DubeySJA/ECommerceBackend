package com.ecommerce.Microservice.user.exception;

public class UserNotFoundException extends NullPointerException {
    public UserNotFoundException() {
        super("User does not exists in the Database");
    }
}
