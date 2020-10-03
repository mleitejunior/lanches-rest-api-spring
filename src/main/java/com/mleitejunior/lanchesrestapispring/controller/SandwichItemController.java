package com.mleitejunior.lanchesrestapispring.controller;

import com.mleitejunior.lanchesrestapispring.model.SandwichItem;
import com.mleitejunior.lanchesrestapispring.service.SandwichItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SandwichItemController {

    @Autowired
    private SandwichItemService service;

    @PostMapping("/sandwich_item")
    public ResponseEntity<SandwichItem> addSandwichItem(@RequestBody SandwichItem sandwichItem) {
        return ResponseEntity.ok(service.saveSandwichItem(sandwichItem));
    }

    @GetMapping("/sandwich_items")
    public ResponseEntity<List<SandwichItem>> findAllSandwichItems() {
        return ResponseEntity.ok(service.getSandwichItems());
    }

    @GetMapping("/sandwich_item/{id}")
    public ResponseEntity<SandwichItem> findSandwichItemById(@PathVariable int id) {
        return ResponseEntity.ok(service.getSandwichItemById(id));
    }

    @GetMapping("/sandwich_items/sandwich/{id}")
    public ResponseEntity<List<SandwichItem>> findAllSandwichItemsBySandwichId(@PathVariable int id) {
        return ResponseEntity.ok(service.findAllSandwichPriceBySandwichId(id));
    }

    @DeleteMapping("/sandwich_item/{id}")
    public ResponseEntity<SandwichItem> deleteSandwichItem(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteSandwichItem(id));
    }
}