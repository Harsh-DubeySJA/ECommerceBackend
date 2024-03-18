package com.ecommerce.Microservice.cart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "usercart")
public class UserCart {

    @Id
    private Long userId;
    private List<Long> imageId;

    public HttpStatus addItem(Long productId) {
        try {
            imageId.add(productId);
            return HttpStatus.ACCEPTED;
        } catch (Exception e) {
            e.printStackTrace();
            return HttpStatus.BAD_REQUEST;
        }
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getImageId() {
        return imageId;
    }

    public void setImageId(List<Long> imageId) {
        this.imageId = imageId;
    }

    public void addImageId(Long productId) {
        imageId.add(productId);
    }

    @Override
    public String toString() {
        return "UserCart{" +
                "userId=" + userId +
                ", imageId=" + Arrays.toString(imageId.toArray()) +
                '}';
    }
}
