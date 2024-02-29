package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.OrderRequest;
@Repository
public interface OrderRepo extends JpaRepository<OrderRequest,Integer>{

}
