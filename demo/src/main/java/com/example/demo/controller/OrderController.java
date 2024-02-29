package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.OrderRequest;
import com.example.demo.model.User;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/admin/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/path")
    public OrderRequest insertNewData(@RequestBody OrderRequest InsertThis)
    {
        return orderService.insertOrder(InsertThis);
    }
    @GetMapping("/getAll")
    public List<OrderRequest> getAllRestaurantOrder()
    {
        return orderService.getOrder();
    }
    @PutMapping("/update/{id}")
    public String UpdateTheOrder(@PathVariable int id,@RequestBody User rb)
    {
        boolean done = orderService.UpdateTheOrder(id, null);
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
    public String DeleteThisOrder(@PathVariable int id)
    {
        boolean done = orderService.deleteOrder(id);
        if(done)
        {
            return "Successfully deleted";
        }
        else
        {
            return "Id Not Found Enter the correct Id to be Deleted";
        }
    }
}
