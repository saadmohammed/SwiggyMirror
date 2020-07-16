package com.example.SwiggyMirror.repository;


import com.example.SwiggyMirror.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    Page<Restaurant> findAll(Pageable pageable);
}
