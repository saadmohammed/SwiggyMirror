package com.example.SwiggyMirror.controller;

import com.example.SwiggyMirror.model.Food;
import com.example.SwiggyMirror.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }


    @GetMapping("/all")
    public Page<Food> getAllFoods(@RequestParam(value = "page") int page,
                                  @RequestParam(value = "limit") int limit) {
        return foodService.findByPage(PageRequest.of(page, limit));
    }

    @PostMapping(value = "/create")
    public void create(@RequestBody Food food) throws InterruptedException {
        foodService.create(food);
    }

    @PutMapping(value = "update/{foodId}")
    public Food updateFood(@PathVariable(value = "foodId") Integer taskId, @RequestBody Food food) {
        return foodService.updateFood(food, taskId);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable Integer userId) {
        foodService.deleteById(userId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
