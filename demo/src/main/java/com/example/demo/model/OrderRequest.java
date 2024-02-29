package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class OrderRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orderId;
    @OneToOne
    @JoinColumn(name = "Restaurant")
    RestaurantBooking restaurantBooking;
    @OneToOne
    @JoinColumn(name="user")
    User user;
    int NumberOfSeats;
    int restaurantId,userId;
    public OrderRequest() {
    }
    public OrderRequest(int orderId, RestaurantBooking restaurantBooking, User user, int numberOfSeats,
            int restaurantId, int userId) {
        this.orderId = orderId;
        this.restaurantBooking = restaurantBooking;
        this.user = user;
        NumberOfSeats = numberOfSeats;
        this.restaurantId = restaurantId;
        this.userId = userId;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public RestaurantBooking getRestaurantBooking() {
        return restaurantBooking;
    }
    public void setRestaurantBooking(RestaurantBooking restaurantBooking) {
        this.restaurantBooking = restaurantBooking;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getNumberOfSeats() {
        return NumberOfSeats;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        NumberOfSeats = numberOfSeats;
    }
    public int getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
