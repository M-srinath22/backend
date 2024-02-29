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

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/path")
    public User insertNewData(@RequestBody User InsertThis)
    {
        return userService.createRestaurant(InsertThis);
    }
    @GetMapping("/getAll")
    public List<User> getAllRestaurantData()
    {
        return userService.getUsers();
    }
    @PutMapping("/update/{id}")
    public String UpdateTheUser(@PathVariable int id,@RequestBody User rb)
    {
        boolean done = userService.updateUsers(id, rb);
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
    public String DeleteThisUser(@PathVariable int id)
    {
        boolean done = userService.deleteUsers(id);
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
