package com.example.foodweb.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categories")
    private Integer idCategories;

    @Column(name = "name_categories")
    private String nameCategories;

    @Column(name = "image_categories")
    private String imageCategories;

    @OneToMany(mappedBy = "categoryFood")
    @JsonManagedReference
    private List<Food> foods;

    // Constructor không tham số
    public CategoryFood() {
    }

    // Constructor với tham số
    public CategoryFood(Integer idCategories, String nameCategories, String imageCategories) {
        this.idCategories = idCategories;
        this.nameCategories = nameCategories;
        this.imageCategories = imageCategories;
    }

    // Getters and setters
    public Integer getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(Integer idCategories) {
        this.idCategories = idCategories;
    }

    public String getNameCategories() {
        return nameCategories;
    }

    public void setNameCategories(String nameCategories) {
        this.nameCategories = nameCategories;
    }

    public String getImageCategories() {
        return imageCategories;
    }

    public void setImageCategories(String imageCategories) {
        this.imageCategories = imageCategories;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
