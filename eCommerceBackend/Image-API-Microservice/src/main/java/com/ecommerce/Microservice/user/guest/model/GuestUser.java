package com.ecommerce.Microservice.user.guest.model;

import jakarta.persistence.*;

@Entity
@Table
public class GuestUser {
    public GuestUser() {
    }

    public GuestUser(Long guestId) {
        this.guestId = guestId;
    }

    public GuestUser(Long guestId, Long userId) {
        this.guestId = guestId;
        this.userId = userId;
    }

    @Id
    @SequenceGenerator(name = "guest_id", sequenceName = "guest_id", allocationSize = 1)
    @GeneratedValue(generator = "guest_id", strategy = GenerationType.UUID)
    private Long guestId;
    private Long userId;

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "GuestUser{" +
                "guestId=" + guestId +
                ", userId=" + userId +
                '}';
    }
}
