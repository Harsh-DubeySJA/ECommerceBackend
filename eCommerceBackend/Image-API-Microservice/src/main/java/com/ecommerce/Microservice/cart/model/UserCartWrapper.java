package com.ecommerce.Microservice.cart.model;

import com.ecommerce.Microservice.model.ImageAPI;
import com.ecommerce.Microservice.service.ImageAPIService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class UserCartWrapper {
    private UserCart userCart;
    private List<ImageAPI> items;

    private ImageAPIService imageAPIService;

    @Autowired
    public UserCartWrapper(ImageAPIService imageAPIService) {
        this.imageAPIService = imageAPIService;
    }

    public UserCartWrapper() {
        generateUserItems();
    }

    private void generateUserItems() {
        try {
            for (Long imageId : userCart.getImageId()) {
                items.add(imageAPIService.getByImageId(imageId));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "UserCartWrapper{" +
                ", items=" + Arrays.toString(items.toArray()) +
                '}';
    }
}
