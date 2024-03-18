package com.ecommerce.Microservice.user.guest.dao;

import com.ecommerce.Microservice.user.guest.model.GuestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestUserRepository extends JpaRepository<GuestUser, Long> {
}
