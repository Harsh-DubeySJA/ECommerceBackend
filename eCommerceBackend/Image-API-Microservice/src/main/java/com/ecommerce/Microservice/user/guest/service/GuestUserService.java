package com.ecommerce.Microservice.user.guest.service;

import com.ecommerce.Microservice.user.guest.dao.GuestUserRepository;
import com.ecommerce.Microservice.user.guest.model.GuestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestUserService {
    private final GuestUserRepository guestUserRepository;

    @Autowired
    public GuestUserService(GuestUserRepository guestUserRepository) {
        this.guestUserRepository = guestUserRepository;
    }

    public void createGuestUser() {
        GuestUser guestUser = new GuestUser();
        guestUserRepository.save(guestUser);
    }
}
