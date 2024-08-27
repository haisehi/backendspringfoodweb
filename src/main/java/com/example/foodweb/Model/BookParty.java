package com.example.foodweb.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "book_party")
public class BookParty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_party")
    private Integer idParty;

    @Column(name = "date_order")
    private LocalDate date_order;

    @Column(name = "time_order")
    private LocalTime time_order;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "address")
    private String address;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false)
    @JsonBackReference
    private Customer customer;

    public  BookParty(){}

    public BookParty(Integer idParty, LocalDate  date_order, LocalTime time_order, int quantity, String address, String content, Customer customer) {
        this.idParty = idParty;
        this.date_order = date_order;
        this.time_order = time_order;
        this.quantity = quantity;
        this.address = address;
        this.content = content;
        this.customer = customer;
    }

    // Getters and setters
    public Integer  getIdParty() {
        return idParty;
    }

    public void setIdParty(Integer  idParty) {
        this.idParty = idParty;
    }

    public LocalDate  getDateOrder() {
        return date_order;
    }

    public void setDateOrder(LocalDate  dateOrder) {
        this.date_order = dateOrder;
    }

    public LocalTime getTimeOrder() {
        return time_order;
    }

    public void setTimeOrder(LocalTime timeOrder) {
        this.time_order = timeOrder;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Thêm phương thức getter để lấy id_categories
    public Integer getCustomerID() {
        return customer != null ? customer.getIdCustomer() : null;
    }

}