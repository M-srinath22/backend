package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @SuppressWarnings("null")
    public User createRestaurant(User user)
    {
        return userRepo.save(user);
    }
    public List<User> getUsers()
    {
        return userRepo.findAll();
    }
    public boolean deleteUsers(int id)
    {
        User toBeDeleted = userRepo.findById(id).orElse(null);
        if(toBeDeleted == null)
        {
            return false;
        }
        else
        {
            userRepo.delete(toBeDeleted);
            return true;
        }
    }
    public boolean updateUsers(int id,User rb)
    {
        User toBeUpdated = userRepo.findById(id).orElse(null);
        if(toBeUpdated == null)
        {
            return false;
        }
        else
        {
            userRepo.save(rb);
            return true;
        }
    }
    public User getById(int id)
    {
        return userRepo.findById(id).orElse(null);
    }
}