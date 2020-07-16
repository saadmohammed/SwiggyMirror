package com.example.SwiggyMirror.service;

import com.example.SwiggyMirror.model.Restaurant;
import com.example.SwiggyMirror.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Page<Restaurant> findByPage(Pageable pageable) {
        return restaurantRepository.findAll(pageable);
    }
}
