package com.ecommerce.Microservice.dao;

import com.ecommerce.Microservice.model.ImageAPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageAPIRepository extends JpaRepository<ImageAPI, Long> {
}
