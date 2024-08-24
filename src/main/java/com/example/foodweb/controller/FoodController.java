package com.example.foodweb.controller;

import com.example.foodweb.Model.CategoryFood;
import com.example.foodweb.Model.Food;
import com.example.foodweb.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    // Thêm món ăn với tên và hình ảnh
    @PostMapping("/add")
    public ResponseEntity<Food> addFood(
            @RequestParam("name_food") String nameFood,
            @RequestParam("price") int price,
            @RequestParam("image_food") String imageFood,
            @RequestParam("id_categories") Integer idCategories) {

        Food food = new Food();
        food.setNameFood(nameFood);
        food.setPrice(price);
        food.setImageFood(imageFood);

        // Tạo đối tượng CategoryFood từ idCategories (cần một service để lấy CategoryFood từ id)
        CategoryFood categoryFood = new CategoryFood(); // Thay thế bằng cách lấy thực tế từ database
        categoryFood.setIdCategories(idCategories);

        food.setCategoryFood(categoryFood);

        Food createdFood = foodService.addFood(food);
        return ResponseEntity.ok(createdFood);
    }

    // Hiển thị tất cả món ăn
    @GetMapping
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> foods = foodService.getAllFoods();
        return ResponseEntity.ok(foods);
    }

    // Hiển thị món ăn theo danh mục
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Food>> getFoodsByCategoryId(@PathVariable Integer categoryId) {
        List<Food> foods = foodService.getFoodsByCategoryId(categoryId);
        return ResponseEntity.ok(foods);
    }

    // Hiển thị món ăn theo id
    @GetMapping("/{foodId}")
    public ResponseEntity<Food> getFoodById(@PathVariable Integer foodId) {
        Food food = foodService.getFoodById(foodId);
        if (food != null) {
            return ResponseEntity.ok(food);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Cập nhật món ăn theo id
    @PutMapping("/{foodId}")
    public ResponseEntity<Food> updateFood(@PathVariable Integer foodId, @RequestBody Food food) {
        Food existingFood = foodService.getFoodById(foodId);
        if (existingFood != null) {
            food.setIdFood(foodId);
            Food updatedFood = foodService.updateFood(food);
            return ResponseEntity.ok(updatedFood);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa món ăn theo id
    @DeleteMapping("/{foodId}")
    public ResponseEntity<Void> deleteFood(@PathVariable Integer foodId) {
        Food existingFood = foodService.getFoodById(foodId);
        if (existingFood != null) {
            foodService.deleteFood(foodId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
