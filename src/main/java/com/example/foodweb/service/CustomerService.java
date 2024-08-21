package com.example.foodweb.service;

import com.example.foodweb.Model.Customer;
import com.example.foodweb.repository.UserReponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final UserReponsitory userReponsitory;

    public Customer getCustomerById(Integer id) {
        return userReponsitory.findById(id).orElse(null);
    }

    public Customer saveCustomer(Customer customer) {
        return userReponsitory.save(customer);
    }
}
