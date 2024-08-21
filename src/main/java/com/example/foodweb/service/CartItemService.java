package com.example.foodweb.service;

import com.example.foodweb.Model.CartItem;
import com.example.foodweb.Model.Customer;
import com.example.foodweb.Model.Food;
import com.example.foodweb.Model.Payment;
import com.example.foodweb.repository.CartItemRepository;
import com.example.foodweb.repository.FoodRepository;
import com.example.foodweb.repository.PaymentRepository;
import com.example.foodweb.repository.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserReponsitory userRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public List<CartItem> getCartItemsByCustomerId(Integer customerId) {
        return userRepository.findById(customerId)
                .map(customer -> cartItemRepository.findByCustomerAndStatus(customer, 0)) // Chỉ lấy các CartItem với status = 0
                .orElse(Collections.emptyList());
    }

    public void addCartItem(Integer customerId, Integer foodId) {
        Customer customer = userRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Food food = foodRepository.findById(foodId)
                .orElseThrow(() -> new RuntimeException("Food not found"));
        Optional<CartItem> existingCartItem = cartItemRepository.findByCustomerAndFood(customer, food);
        if (existingCartItem.isPresent()) {
            CartItem cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            cartItemRepository.save(cartItem);
        } else {
            CartItem newCartItem = new CartItem();
            newCartItem.setCustomer(customer);
            newCartItem.setFood(food);
            newCartItem.setQuantity(1);
            newCartItem.setStatus(0); // Đặt status mặc định là 0
            cartItemRepository.save(newCartItem);
        }
    }

    public void removeCartItem(Integer cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public void updateCartItemQuantity(Integer cartItemId, int quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }

    public void processPayment(Integer customerId, String address) {
        Customer customer = userRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Lấy tất cả các CartItem có status = 0 của customer
        List<CartItem> cartItems = cartItemRepository.findByCustomerAndStatus(customer, 0);

        // Xử lý thanh toán cho từng cart item
        for (CartItem cartItem : cartItems) {
            // Tạo một bản ghi payment mới
            Payment payment = new Payment();
            payment.setNameFood(cartItem.getFood().getNameFood());
            payment.setPrice(cartItem.getFood().getPrice());
            payment.setTotal(cartItem.getQuantity() * cartItem.getFood().getPrice());
            payment.setQuantity(cartItem.getQuantity());
            payment.setAddress(address);  // Sử dụng địa chỉ từ tham số
            payment.setCartItem(cartItem);
            payment.setTime(LocalDateTime.now()); // Đặt thời gian thanh toán hiện tại

            // Lưu payment vào database
            paymentRepository.save(payment);

            // Cập nhật status của cart item về 1
            cartItem.setStatus(1);
            cartItemRepository.save(cartItem);
        }
    }


    public List<Payment> getPaymentsByCustomerId(Integer customerId) {
        return userRepository.findById(customerId)
                .map(customer -> paymentRepository.findByCartItemCustomer(customer))
                .orElse(Collections.emptyList());
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Transactional
    public void updatePaymentStatus(Integer idPayment) {
        paymentRepository.updatePaymentStatus(idPayment);
    }


}

