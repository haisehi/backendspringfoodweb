package com.example.foodweb.repository;

import com.example.foodweb.Model.CategoryFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryFoodRepository extends JpaRepository<CategoryFood, Integer> {
}