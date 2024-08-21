package com.example.foodweb.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.util.List;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_food")
    private Integer idFood;
    @Column(name = "name_food")
    private String nameFood;
    @Column(name = "image_food")
    private String imageFood;
    private int price;

    @ManyToOne
    @JoinColumn(name = "id_categories", nullable = false)
    @JsonBackReference
    private CategoryFood categoryFood;

//    @OneToMany(mappedBy = "food")
//    @JsonManagedReference
//    private <CartItem> cartItems;

    // Getters and setters
    public  Food(){

    }

    public Food(Integer idFood, String nameFood, String imageFood, int price, CategoryFood categoryFood) {
        this.idFood = idFood;
        this.nameFood = nameFood;
        this.imageFood = imageFood;
        this.price = price;
        this.categoryFood = categoryFood;
    }

    public Integer getIdFood() {
        return idFood;
    }

    public void setIdFood(Integer idFood) {
        this.idFood = idFood;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getImageFood() {
        return imageFood;
    }

    public void setImageFood(String imageFood) {
        this.imageFood = imageFood;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CategoryFood getCategoryFood() { // Sửa getter
        return categoryFood;
    }

    public void setCategoryFood(CategoryFood categoryFood) { // Sửa setter
        this.categoryFood = categoryFood;
    }
}

