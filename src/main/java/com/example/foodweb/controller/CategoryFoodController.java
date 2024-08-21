package com.example.foodweb.controller;

import com.example.foodweb.Model.CategoryFood;
import com.example.foodweb.service.CategoryFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/categories")
public class CategoryFoodController {

    @Autowired
    private CategoryFoodService categoryFoodService;
    //  thêm danh mục
    @PostMapping
    public ResponseEntity<CategoryFood> addCategoryFood(@RequestBody CategoryFood categoryFood) {
        CategoryFood createdCategory = categoryFoodService.addCategoryFood(categoryFood);
        return ResponseEntity.ok(createdCategory);
    }
    // lấy tất cả danh mục
    @GetMapping
    public ResponseEntity<List<CategoryFood>> getAllCategories() {
        List<CategoryFood> categories = categoryFoodService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
    // lấy danh mục theo id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryFood> getCategoryById(@PathVariable Integer id) {
        CategoryFood category = categoryFoodService.getCategoryById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // sửa danh mục theo id
    @PutMapping("/{id}")
    public ResponseEntity<CategoryFood> updateCategoryFood(@PathVariable Integer id, @RequestBody CategoryFood categoryFood) {
        CategoryFood existingCategory = categoryFoodService.getCategoryById(id);
        if (existingCategory != null) {
            categoryFood.setIdCategories(id);
            CategoryFood updatedCategory = categoryFoodService.updateCategoryFood(categoryFood);
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // xoá danh mục theo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryFood(@PathVariable Integer id) {
        CategoryFood existingCategory = categoryFoodService.getCategoryById(id);
        if (existingCategory != null) {
            categoryFoodService.deleteCategoryFood(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}