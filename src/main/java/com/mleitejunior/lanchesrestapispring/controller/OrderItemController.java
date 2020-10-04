package com.mleitejunior.lanchesrestapispring.controller;

import com.mleitejunior.lanchesrestapispring.model.OrderItem;
import com.mleitejunior.lanchesrestapispring.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemService service;

    @PostMapping("/order_item")
    public ResponseEntity<OrderItem> addOrderItem(@RequestBody OrderItem orderItem) {
        return ResponseEntity.ok(service.saveOrderItem(orderItem));
    }

    @GetMapping("/order_item")
    public ResponseEntity<List<OrderItem>> findAllOrderItems() {
        return ResponseEntity.ok(service.getOrderItems());
    }

    @GetMapping("/order_item/{id}")
    public ResponseEntity<OrderItem> findOrderItemById(@PathVariable int id) {
        return ResponseEntity.ok(service.getOrderItemById(id));
    }

    @GetMapping("/order_item/sandwich/{id}")
    public ResponseEntity<List<OrderItem>> findAllOrderItemsByOrderId(@PathVariable int id) {
        return ResponseEntity.ok(service.findAllOrderItemsByOrderId(id));
    }

    @DeleteMapping("/order_item/{id}")
    public ResponseEntity<OrderItem> deleteOrderItem(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteOrderItem(id));
    }
}