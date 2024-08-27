package com.example.foodweb.repository;

import com.example.foodweb.Model.BookParty;
import com.example.foodweb.Model.Customer;
import com.example.foodweb.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookPartyRepository extends JpaRepository<BookParty, Integer> {
    List<BookParty> findByCustomer(Customer customer);
}