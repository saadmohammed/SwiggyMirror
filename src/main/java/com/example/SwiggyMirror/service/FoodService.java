package com.example.SwiggyMirror.service;

import com.example.SwiggyMirror.exception.ResourceNotFoundException;
import com.example.SwiggyMirror.model.Food;
import com.example.SwiggyMirror.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Page<Food> findByPage(Pageable pageable) {
        return foodRepository.findAll(pageable);
    }

    public void create(Food food) {
        foodRepository.save(food);
    }

    public Food updateFood(Food food, Integer foodId) {
        foodRepository.findById(foodId)
                .orElseThrow(() -> new ResourceNotFoundException("Food", "id", foodId));
        return foodRepository.save(food);
    }

    public void deleteById(Integer id) {
        foodRepository.deleteById(id);
    }

}
