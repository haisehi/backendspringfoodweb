package com.example.foodweb.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Integer idPayment;

    @Column(name = "name_food")
    private String nameFood;

    @Column(name = "price")
    private float price;

    @Column(name = "total")
    private float total;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "address")
    private String address;

    @Column(name = "time", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime time;

    @Column(name = "status_pay")
    private int statusPay =0;  // Thêm trường statusPay

    @ManyToOne
    @JoinColumn(name = "id_cart", nullable = false)
    @JsonBackReference
    private CartItem cartItem;

//    constructor
    public Payment() {}

    public Payment(Integer idPayment, String nameFood, float price, float total, int quantity, String address, LocalDateTime time, int statusPay, CartItem cartItem) {
        this.idPayment = idPayment;
        this.nameFood = nameFood;
        this.price = price;
        this.total = total;
        this.quantity = quantity;
        this.address = address;
        this.time = time;
        this.statusPay = statusPay;  // Thêm giá trị statusPay vào constructor
        this.cartItem = cartItem;
    }

    // Getters and setters
    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getStatusPay() {
        return statusPay;
    }

    public void setStatusPay(int statusPay) {
        this.statusPay = statusPay;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    // Thêm phương thức getter để lấy id_categories
    public Integer getIdCart() {
        return cartItem != null ? cartItem.getIdCart() : null;
    }
}
