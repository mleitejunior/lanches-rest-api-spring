package com.mleitejunior.lanchesrestapispring.controller;

import com.mleitejunior.lanchesrestapispring.model.Order;
import com.mleitejunior.lanchesrestapispring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/order")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        return ResponseEntity.ok(service.saveOrder(order));
    }

    @GetMapping("/order")
    public ResponseEntity<List<Order>> findAllOrders() {
        return ResponseEntity.ok(service.getOrders());
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable int id) {
        return ResponseEntity.ok(service.getOrderById(id));
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteOrder(id));
    }
}