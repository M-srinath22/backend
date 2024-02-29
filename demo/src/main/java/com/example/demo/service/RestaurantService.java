package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.RestaurantBooking;
import com.example.demo.repository.RestaurantRepo;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepo restaurantRepo;
    @SuppressWarnings("null")
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
            restaurantRepo.save(rb);
            return true;
        }
    }
    public RestaurantBooking getById(int id)
    {
        return restaurantRepo.findById(id).orElse(null);
    }
    //Sorting
    public List<RestaurantBooking> sortByRestaurantBookingName(String RestaurantName)
    {
        Sort sort = Sort.by(RestaurantName).ascending();
        return (List<RestaurantBooking>) restaurantRepo.findAll(sort);
    }
    //pagenation
    public List<RestaurantBooking> paginationOfRestaurantBookings(int pageSize,int pageNo)
    {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page<RestaurantBooking> pages = restaurantRepo.findAll(pageRequest);
        return pages.toList();
    }
    //sorting + pagination
    public List<RestaurantBooking> SortAndPagenation(int pageSize,int pageNo,String SortBy)
    {
        Sort sort = Sort.by(SortBy).ascending();
        PageRequest page = PageRequest.of(pageNo, pageSize,sort);
        Page<RestaurantBooking> pages = restaurantRepo.findAll(page);
        return pages.toList();
    }
}