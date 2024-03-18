package com.ecommerce.Microservice.cart.dao;

import com.ecommerce.Microservice.cart.model.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<UserCart, Long> {
}
