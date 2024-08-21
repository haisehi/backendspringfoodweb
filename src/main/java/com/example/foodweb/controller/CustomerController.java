package com.example.foodweb.controller;

import com.example.foodweb.Model.Customer;
import com.example.foodweb.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id_customer}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id_customer") Integer id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id_customer}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id_customer") Integer id,
                                                   @RequestBody Customer updatedCustomer) {
        Customer existingCustomer = customerService.getCustomerById(id);
        if (existingCustomer != null) {
            existingCustomer.setFirstname(updatedCustomer.getFirstname());
            existingCustomer.setLastname(updatedCustomer.getLastname());
            existingCustomer.setPhonenumber(updatedCustomer.getPhonenumber());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setGender(updatedCustomer.getGender());
            existingCustomer.setDate(updatedCustomer.getDate());
            // Add other fields as needed
            customerService.saveCustomer(existingCustomer);
            return ResponseEntity.ok(existingCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
