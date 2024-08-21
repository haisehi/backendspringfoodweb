package com.example.foodweb.controller;

import com.example.foodweb.Model.CartItem;
import com.example.foodweb.Model.Customer;
import com.example.foodweb.Model.Food;
import com.example.foodweb.Model.Payment;
import com.example.foodweb.service.CartItemService;
import com.example.foodweb.repository.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/cart")
public class CartController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UserReponsitory userRepository;

    @GetMapping
    public ResponseEntity<List<CartItem>> getCartItemsByCustomerId(@RequestParam("customerId") Integer customerId) {
        List<CartItem> cartItems = cartItemService.getCartItemsByCustomerId(customerId);
        return ResponseEntity.ok(cartItems);
    }

    @PostMapping("/add/{foodId}/{customerId}")
    public void addCartItem(@PathVariable Integer foodId, @PathVariable Integer customerId) {
        cartItemService.addCartItem(customerId, foodId);
    }

    @DeleteMapping("/remove/{cartItemId}")
    public void removeCartItem(@PathVariable Integer cartItemId) {
        cartItemService.removeCartItem(cartItemId);
    }

    @PutMapping("/update/{cartItemId}")
    public void updateCartItemQuantity(@PathVariable Integer cartItemId, @RequestParam int quantity) {
        cartItemService.updateCartItemQuantity(cartItemId, quantity);
    }


    @PostMapping("/checkout/{customerId}")
    public ResponseEntity<String> processPayment(
            @PathVariable Integer customerId,
            @RequestParam String address) {
        cartItemService.processPayment(customerId, address);
        return ResponseEntity.ok("Payment processed successfully");
    }

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = cartItemService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/payments/{customerId}")
    public ResponseEntity<List<Payment>> getPaymentsByCustomerId(@PathVariable Integer customerId) {
        List<Payment> payments = cartItemService.getPaymentsByCustomerId(customerId);
        return ResponseEntity.ok(payments);
    }

    @PutMapping("/update_status/{idPayment}")
    public ResponseEntity<String> updatePaymentStatus(@PathVariable Integer idPayment) {
        cartItemService.updatePaymentStatus(idPayment);
        return ResponseEntity.ok("Payment status updated successfully");
    }

}
