package com.example.foodweb.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
@Table(name = "book_party")
public class BookParty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_party")
    private Integer idParty;

    @Column(name = "dateOrder")
    private Date dateOrder;

    @Column(name = "timeOrder")
    private String timeOrder;

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

    public BookParty(Integer idParty, Date dateOrder, String timeOrder, int quantity, String address, String content, Customer customer) {
        this.idParty = idParty;
        this.dateOrder = dateOrder;
        this.timeOrder = timeOrder;
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

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(String timeOrder) {
        this.timeOrder = timeOrder;
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
}