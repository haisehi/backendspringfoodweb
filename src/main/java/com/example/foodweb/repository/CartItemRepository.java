package com.example.foodweb.repository;

import com.example.foodweb.Model.CartItem;
import com.example.foodweb.Model.Customer;
import com.example.foodweb.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByCustomer(Customer customerID);
    Optional<CartItem> findByCustomerAndFood(Customer customer, Food food);
    List<CartItem> findByCustomerAndStatus(Customer customer, int status); // Tìm CartItem theo Customer và status
}

