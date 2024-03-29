package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RestaurantBooking;
import com.example.demo.service.RestaurantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/admin/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;
    @PostMapping("/path")
    public RestaurantBooking insertNewData(@RequestBody RestaurantBooking InsertThis)
    {
        return restaurantService.createRestaurant(InsertThis);
    }
    @GetMapping("/getAll")
    public List<RestaurantBooking> getAllRestaurantData()
    {
        return restaurantService.getRestaurantBookings();
    }
    @PutMapping("/update/{id}")
    public String UpdateTheRestaurant(@PathVariable int id,@RequestBody RestaurantBooking rb)
    {
        boolean done = restaurantService.updateRestaurantBooking(id, rb);
        if(done)
        {
            return "Successfully updated";
        }
        else
        {
            return "Id not found Enter the correct Id to be uploaded";
        }
    }
    @DeleteMapping("/delete/{id}")
    public String DeleteThisRestaurant(@PathVariable int id)
    {
        boolean done = restaurantService.deleteRestaurantBooking(id);
        if(done)
        {
            return "Successfully deleted";
        }
        else
        {
            return "Id Not Found Enter the correct Id to be Deleted";
        }
    }
    //Sort
    @GetMapping("/display/{name}")
    public List<RestaurantBooking> getByFlightNameSorted(@PathVariable("name") String name)
    {
        List<RestaurantBooking> restaurantList = restaurantService.sortByRestaurantBookingName(name);
        return restaurantList;
    }
    //pagination
    @GetMapping("/display/{pageSize}/{pageNumber}")
    public List<RestaurantBooking> getPagination(@PathVariable("pageSize") int pageSize,@PathVariable("pageNumber") int pageNumber)
    {
        List<RestaurantBooking> restaurantList = restaurantService.paginationOfRestaurantBookings(pageSize, pageNumber);
        return restaurantList;
    }
    //pagination + sorting
    @GetMapping("/display/{pageSize}/{pageNumber}/{field}")
    public List<RestaurantBooking> getPaginationandSort(@PathVariable("pageSize") int pageSize,@PathVariable("pageNumber") int pageNumber,@PathVariable("field") String field)
    {
        List<RestaurantBooking> restaurantList = restaurantService.SortAndPagenation(pageSize, pageNumber, field);
        return restaurantList;
    }
}