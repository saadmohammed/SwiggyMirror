package com.example.SwiggyMirror.controller;

import com.example.SwiggyMirror.dto.OrderDto;
import com.example.SwiggyMirror.model.Order;
import com.example.SwiggyMirror.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/myorders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public Page<Order> getAllOrders(@RequestParam(name = "page") int page,
                                    @RequestParam(name = "limit") int limit) {
        return orderService.SeeOrder(PageRequest.of(page, limit));
    }

    @PostMapping("/createOrder")
    public Order orderFood(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @PutMapping("/updateOrder/{id}")
    public Order updateOrder(@RequestBody Order order, @PathVariable(value = "id") Integer id) {
        return orderService.updateOrder(order, id);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable(value = "id") Integer id) {
        orderService.deleteOrder(id);
    }
}
