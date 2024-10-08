package com.example.foodweb.repository;

import com.example.foodweb.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    List<Food> findByCategoryFoodIdCategories(Integer categoryId);
}