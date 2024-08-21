package com.example.foodweb.controller;

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
    //    thêm món ăn
    @PostMapping
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        Food createdFood = foodService.addFood(food);
        return ResponseEntity.ok(createdFood);
    }
    //  hiển thị tất cả món ăn
    @GetMapping
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> foods = foodService.getAllFoods();
        return ResponseEntity.ok(foods);
    }
    //  hiển thị món ăn theo danh mục
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Food>> getFoodsByCategoryId(@PathVariable Integer categoryId) {
        List<Food> foods = foodService.getFoodsByCategoryId(categoryId);
        return ResponseEntity.ok(foods);
    }
    //  hiển thị món ăn theo id món ăn
    @GetMapping("/{foodId}")
    public ResponseEntity<Food> getFoodById(@PathVariable Integer foodId) {
        Food food = foodService.getFoodById(foodId);
        if (food != null) {
            return ResponseEntity.ok(food);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // cập nhật món ăn theo id món ăn
    @PutMapping("/{foodId}")
    public ResponseEntity<Food> updateFood(@PathVariable Integer foodId, @RequestBody Food food) {
        food.setIdFood(foodId);
        Food updatedFood = foodService.updateFood(food);
        return ResponseEntity.ok(updatedFood);
    }
    // xoá món ăn theo id món ăn
    @DeleteMapping("/{foodId}")
    public ResponseEntity<Void> deleteFood(@PathVariable Integer foodId) {
        foodService.deleteFood(foodId);
        return ResponseEntity.noContent().build();
    }
}