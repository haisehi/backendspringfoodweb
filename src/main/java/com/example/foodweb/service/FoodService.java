package com.example.foodweb.service;

import com.example.foodweb.Model.Food;
import com.example.foodweb.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public List<Food> getFoodsByCategoryId(Integer categoryId) {
        return foodRepository.findByCategoryFoodIdCategories(categoryId);
    }

    public Food getFoodById(Integer foodId) {
        Optional<Food> result = foodRepository.findById(foodId);
        return result.orElse(null);
    }

    public Food updateFood(Food food) {
        return foodRepository.save(food);
    }

    public void deleteFood(Integer foodId) {
        foodRepository.deleteById(foodId);
    }
}