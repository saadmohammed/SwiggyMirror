package com.example.SwiggyMirror.controller;

import com.example.SwiggyMirror.model.Food;
import com.example.SwiggyMirror.model.Restaurant;
import com.example.SwiggyMirror.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/all")
    public Page<Restaurant> getAllFoods(@RequestParam(value = "page") int page,
                                        @RequestParam(value = "limit") int limit){
        return restaurantService.findByPage(PageRequest.of(page, limit));
    }

}
