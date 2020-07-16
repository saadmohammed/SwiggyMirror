package com.example.SwiggyMirror.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "food", schema = "public")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer food_id;
    @Column(name = "name")
    private String food_name;
    @Column(name = "category")
    private String food_category;
    @Column(name = "quantity")
    private String food_quantity;
    @Column(name = "price")
    private Integer food_price;
    @Column(name = "restaurant_id")
    private String restaurant_id;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "food")
//    private Set<Order> order   = new HashSet<>();

    public Food() {
    }

    public Food(Integer food_id, String food_name, String food_category, String food_quantity, Integer food_price, String restaurant_id) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.food_category = food_category;
        this.food_quantity = food_quantity;
        this.food_price = food_price;
        this.restaurant_id = restaurant_id;
    }

    public Integer getFood_id() {
        return food_id;
    }

    public void setFood_id(Integer food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_category() {
        return food_category;
    }

    public void setFood_category(String food_category) {
        this.food_category = food_category;
    }

    public String getFood_quantity() {
        return food_quantity;
    }

    public void setFood_quantity(String food_quantity) {
        this.food_quantity = food_quantity;
    }

    public Integer getFood_price() {
        return food_price;
    }

    public void setFood_price(Integer food_price) {
        this.food_price = food_price;
    }

    public String getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(String restaurant_id) {
        this.restaurant_id = restaurant_id;
    }


}