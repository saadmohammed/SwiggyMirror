package com.example.SwiggyMirror.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order", schema = "public")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;
    @Column(name = "price")
    private Integer price;
    @Column(name = "status")
    private String status;
    @Column(name = "date")
    private Date date;
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "food")
    private Integer food_id;
    @Column(name = "stock")
    private Integer stock;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "food", referencedColumnName = "id", insertable = false, updatable = false)
    private Food food;

    public Order(Integer id, Integer price, String status, Date date, Integer user_id, Integer food_id, User user, Food food, Integer stock) {
        this.id = id;
        this.price = price;
        this.status = status;
        this.date = date;
        this.user_id = user_id;
        this.food_id = food_id;
        this.user = user;
        this.food = food;
        this.stock = stock;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getFood_id() {
        return food_id;
    }

    public void setFood_id(Integer food_id) {
        this.food_id = food_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
