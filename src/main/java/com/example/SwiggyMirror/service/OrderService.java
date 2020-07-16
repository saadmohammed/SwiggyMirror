package com.example.SwiggyMirror.service;

import com.example.SwiggyMirror.exception.ResourceNotFoundException;
import com.example.SwiggyMirror.model.Order;
import com.example.SwiggyMirror.repository.FoodRepository;
import com.example.SwiggyMirror.repository.OrderRepository;
import com.example.SwiggyMirror.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final FoodRepository foodRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderService(FoodRepository foodRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.foodRepository = foodRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Page<Order> SeeOrder(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order, Integer id) {
        orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with ", "id = ", id));
        return orderRepository.save(order);
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

}
