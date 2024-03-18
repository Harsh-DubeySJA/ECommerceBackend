package com.ecommerce.Microservice.user.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Lazy;

@Entity
@Table(name = "user")
@Lazy
public class User {

    @Id
    @SequenceGenerator(name = "user_id", sequenceName = "user_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.UUID, generator = "user_id")
    private Long userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;

    public User() {
        this.firstName = null;
        this.lastName = null;
        this.userName = null;
        this.password = null;
        this.email = null;
    }

    public User(String firstName, String lastName, String userName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public User(Long userId, String firstName, String lastName, String userName, String password, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
