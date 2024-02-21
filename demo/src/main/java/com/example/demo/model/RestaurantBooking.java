package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RestaurantBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int restaurantId;
    String restaurantName;
    int highRated;
    int lowRated;
    int price;
    public RestaurantBooking() {
    }
    public RestaurantBooking(int restaurantId, String restaurantName, int highRated, int lowRated, int price) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.highRated = highRated;
        this.lowRated = lowRated;
        this.price = price;
    }
    public int getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
    public String getRestaurantName() {
        return restaurantName;
    }
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
    public int getHighRated() {
        return highRated;
    }
    public void setHighRated(int highRated) {
        this.highRated = highRated;
    }
    public int getLowRated() {
        return lowRated;
    }
    public void setLowRated(int lowRated) {
        this.lowRated = lowRated;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
}
