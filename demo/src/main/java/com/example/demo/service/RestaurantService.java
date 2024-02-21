package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.RestaurantBooking;
import com.example.demo.repository.RestaurantRepo;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepo restaurantRepo;
    public RestaurantBooking createRestaurant(RestaurantBooking restaurantBooking)
    {
        return restaurantRepo.save(restaurantBooking);
    }
    public List<RestaurantBooking> getRestaurantBookings()
    {
        return restaurantRepo.findAll();
    }
    public boolean deleteRestaurantBooking(int id)
    {
        RestaurantBooking toBeDeleted = restaurantRepo.findById(id).orElse(null);
        if(toBeDeleted == null)
        {
            return false;
        }
        else
        {
            restaurantRepo.delete(toBeDeleted);
            return true;
        }
    }
    public boolean updateRestaurantBooking(int id,RestaurantBooking rb)
    {
        RestaurantBooking toBeUpdated = restaurantRepo.findById(id).orElse(null);
        if(toBeUpdated == null)
        {
            return false;
        }
        else
        {
            toBeUpdated.setRestaurantId(rb.getRestaurantId());
            toBeUpdated.setHighRated(rb.getHighRated());
            toBeUpdated.setLowRated(rb.getLowRated());
            toBeUpdated.setPrice(rb.getPrice());
            toBeUpdated.setRestaurantName(rb.getRestaurantName());
            return true;
        }
    }
}
