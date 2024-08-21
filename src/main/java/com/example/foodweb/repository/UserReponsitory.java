package com.example.foodweb.repository;

import com.example.foodweb.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserReponsitory extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);
}
