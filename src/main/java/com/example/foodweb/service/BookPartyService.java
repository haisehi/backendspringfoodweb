package com.example.foodweb.service;

import com.example.foodweb.Model.BookParty;
import com.example.foodweb.Model.Customer;
import com.example.foodweb.repository.BookPartyRepository;
import com.example.foodweb.repository.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookPartyService {

    @Autowired
    private BookPartyRepository bookPartyRepository;

    @Autowired
    private UserReponsitory userRepository;

    // Lưu thông tin book party
    public BookParty saveBookParty(BookParty bookParty, Integer customerId) {
        Customer customer = userRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        bookParty.setCustomer(customer);
        return bookPartyRepository.save(bookParty);
    }

    // Hiển thị danh sách book party theo khách hàng
    public List<BookParty> getBookPartiesByCustomerId(Integer customerId) {
        Customer customer = userRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return bookPartyRepository.findByCustomer(customer);
    }

    // Hiển thị tất cả các book party
    public List<BookParty> getAllBookParties() {
        return bookPartyRepository.findAll();
    }
}
