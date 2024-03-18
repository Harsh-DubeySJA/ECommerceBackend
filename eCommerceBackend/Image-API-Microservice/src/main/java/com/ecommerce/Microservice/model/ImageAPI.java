package com.ecommerce.Microservice.model;

import jakarta.persistence.*;

@Entity
@Table
public class ImageAPI {

    public ImageAPI() {
    }

    public ImageAPI(String imageLink, String imageName, String imageDescription) {
        this.imageLink = imageLink;
        this.imageName = imageName;
        this.imageDescription = imageDescription;
    }

    public ImageAPI(Long imageId, String imageLink, String imageName, String imageDescription) {
        this.imageId = imageId;
        this.imageLink = imageLink;
        this.imageName = imageName;
        this.imageDescription = imageDescription;
    }

    @Id
    @SequenceGenerator(name = "image_id", sequenceName = "image_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.UUID, generator = "image_id")
    private Long imageId;
    private String imageLink;
    private String imageName;
    private String imageDescription;

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    @Override
    public String toString() {
        return "ImageAPI{" +
                "imageId=" + imageId +
                ", imageLink='" + imageLink + '\'' +
                ", imageName='" + imageName + '\'' +
                ", imageDescription='" + imageDescription + '\'' +
                '}';
    }
}
