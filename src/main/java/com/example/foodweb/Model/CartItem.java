package com.example.foodweb.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
@Table(name = "cart")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cart")
    private Integer idCart;

    @ManyToOne
    @JoinColumn(name = "ID_food", nullable = false)
    private Food food;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    @JsonBackReference
    private Customer customer;

    private int quantity;

    @Column(name = "status", nullable = false)
    private int status = 0; // Mặc định là 0

    public CartItem(){}

    public CartItem(Integer idCart, Food food, Customer customer, int quantity, int status) {
        this.idCart = idCart;
        this.food = food;
        this.customer = customer;
        this.quantity = quantity;
        this.status = status;
    }

    // Getters and setters
    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status; }
}