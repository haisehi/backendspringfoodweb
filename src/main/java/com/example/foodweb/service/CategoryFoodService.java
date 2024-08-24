package com.example.foodweb.service;

import com.example.foodweb.Model.CategoryFood;
import com.example.foodweb.repository.CategoryFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryFoodService {

    @Autowired
    private CategoryFoodRepository categoryFoodRepository;

    public CategoryFood addCategoryFood(CategoryFood categoryFood) {
        return categoryFoodRepository.save(categoryFood);
    }

    public List<CategoryFood> getAllCategories() {
        return categoryFoodRepository.findAll();
    }

    public CategoryFood getCategoryById(Integer id) {
        return categoryFoodRepository.findById(id).orElse(null);
    }

    public CategoryFood updateCategoryFood(CategoryFood categoryFood) {
        return categoryFoodRepository.save(categoryFood);
    }

    public void deleteCategoryFood(Integer id) {
        categoryFoodRepository.deleteById(id);
    }
}
