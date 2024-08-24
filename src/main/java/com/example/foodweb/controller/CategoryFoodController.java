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

    // Thêm danh mục với tên hình ảnh
    @PostMapping("/add")
    public ResponseEntity<CategoryFood> addCategoryFood(
            @RequestParam("name_categories") String nameCategories,
            @RequestParam("image_categories") String imageCategories) {
        CategoryFood categoryFood = new CategoryFood();
        categoryFood.setNameCategories(nameCategories);
        categoryFood.setImageCategories(imageCategories);
        CategoryFood createdCategory = categoryFoodService.addCategoryFood(categoryFood);
        return ResponseEntity.ok(createdCategory);
    }

    // Lấy tất cả danh mục
    @GetMapping
    public ResponseEntity<List<CategoryFood>> getAllCategories() {
        List<CategoryFood> categories = categoryFoodService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    // Lấy danh mục theo id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryFood> getCategoryById(@PathVariable Integer id) {
        CategoryFood category = categoryFoodService.getCategoryById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Sửa danh mục theo id
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

    // Xóa danh mục theo id
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
