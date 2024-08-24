package com.example.foodweb.controller;

import com.example.foodweb.Model.BookParty;
import com.example.foodweb.Model.Customer;
import com.example.foodweb.repository.BookPartyRepository;
import com.example.foodweb.repository.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
@RequestMapping("/api/v1/auth/bookparty")
public class BookingController {

    @Autowired
    private BookPartyRepository bookPartyRepository;

    @Autowired
    private UserReponsitory customerRepository;

    @PostMapping("/bookParty")
    public String bookParty(@RequestParam("id_customer") Integer idCustomer,
                            @RequestParam("dateOrder") Date dateOrder,
                            @RequestParam("timeOrder") String timeOrder,
                            @RequestParam("quantity") int quantity,
                            @RequestParam("address") String address,
                            @RequestParam("content") String content,
                            Model model) {

        Customer customer = customerRepository.findById(idCustomer).orElse(null);

        if (customer != null) {
            BookParty bookParty = new BookParty();
            bookParty.setDateOrder(dateOrder);
            bookParty.setTimeOrder(timeOrder);
            bookParty.setQuantity(quantity);
            bookParty.setAddress(address);
            bookParty.setContent(content);
            bookParty.setCustomer(customer);

            bookPartyRepository.save(bookParty);
            model.addAttribute("message", "Booking successful!");

            return "confirmation"; // Chuyển đến trang xác nhận
        } else {
            model.addAttribute("error", "Customer not found");
            return "error"; // Chuyển đến trang lỗi
        }
    }
}
