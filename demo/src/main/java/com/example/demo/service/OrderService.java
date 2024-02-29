package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.OrderRequest;
import com.example.demo.model.RestaurantBooking;
import com.example.demo.model.User;
import com.example.demo.repository.OrderRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    RestaurantService restaurantService;
    @Autowired
    UserService userService;
    //insert
    public OrderRequest insertOrder(OrderRequest orderRequest)
    {
        int restaurantId=orderRequest.getRestaurantId();
        int userId = orderRequest.getOrderId();
        RestaurantBooking restaurantBooking=restaurantService.getById(restaurantId);
        User user=userService.getById(userId);
        orderRequest.setRestaurantBooking(restaurantBooking);
        orderRequest.setUser(user);
        return orderRepo.save(orderRequest);
    }
     public List<OrderRequest> getOrder()
    {
        return orderRepo.findAll();
    }
    public boolean deleteOrder(int id)
    {
        OrderRequest toBeDeleted = orderRepo.findById(id).orElse(null);
        if(toBeDeleted == null)
        {
            return false;
        }
        else
        {
            orderRepo.delete(toBeDeleted);
            return true;
        }
    }
    @SuppressWarnings("null")
    public boolean UpdateTheOrder(int id,OrderRequest o)
    {
        OrderRequest toBeUpdated = orderRepo.findById(id).orElse(null);
        if(toBeUpdated == null)
        {
            return false;
        }
        else
        {
            orderRepo.save(o);
            return true;
        }
    }
    public OrderRequest getById(int id)
    {
        return orderRepo.findById(id).orElse(null);
    }
}
