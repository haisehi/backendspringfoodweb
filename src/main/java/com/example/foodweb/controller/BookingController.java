package com.example.foodweb.controller;

import com.example.foodweb.Model.BookParty;
import com.example.foodweb.service.BookPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/api/v1/auth/bookparty")
public class BookingController {

    @Autowired
    private BookPartyService bookPartyService;

    // Thêm mới một book party
    @PostMapping("/add")
    public ResponseEntity<BookParty> addBookParty(@RequestBody BookParty bookParty, @RequestParam Integer customerId) {
        BookParty newBookParty = bookPartyService.saveBookParty(bookParty, customerId);
        return ResponseEntity.ok(newBookParty);
    }

    // Lấy danh sách book party theo ID khách hàng
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<BookParty>> getBookPartiesByCustomer(@PathVariable Integer customerId) {
        List<BookParty> bookParties = bookPartyService.getBookPartiesByCustomerId(customerId);
        return ResponseEntity.ok(bookParties);
    }

    // Lấy danh sách tất cả các book party
    @GetMapping("/all")
    public ResponseEntity<List<BookParty>> getAllBookParties() {
        List<BookParty> bookParties = bookPartyService.getAllBookParties();
        return ResponseEntity.ok(bookParties);
    }
}
