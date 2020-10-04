package com.mleitejunior.lanchesrestapispring.controller;

import com.mleitejunior.lanchesrestapispring.model.OrderItem;
import com.mleitejunior.lanchesrestapispring.model.Sandwich;
import com.mleitejunior.lanchesrestapispring.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SandwichController {

    @Autowired
    private SandwichService service;

    @PostMapping("/sandwich")
    public ResponseEntity<Sandwich> addSandwich(@RequestBody Sandwich sandwich) {
        return ResponseEntity.ok(service.saveSandwich(sandwich));
    }

    @PostMapping("/sandwiches")
    public ResponseEntity<List<Sandwich>> addSandwich(@RequestBody List<Sandwich> sandwiches) {
        return ResponseEntity.ok(service.saveSandwich(sandwiches));
    }

    @GetMapping("/sandwich")
    public ResponseEntity<List<Sandwich>> findAllSandwiches() {
        return ResponseEntity.ok(service.getSandwiches());
    }

    @GetMapping("/sandwich/{id}")
    public ResponseEntity<Sandwich> findSandwichById(@PathVariable int id) {
        return ResponseEntity.ok(service.getSandwichById(id));
    }

    @GetMapping("/sandwich/name/{name}")
    public ResponseEntity<Sandwich> findSandwichByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getSandwichByName(name));
    }
    
    @PutMapping("/sandwich")
    public ResponseEntity<Sandwich> updateSandwich(@RequestBody Sandwich sandwich) {
        return ResponseEntity.ok(service.updateSandwich(sandwich));
    }

    @DeleteMapping("/sandwich/{id}")
    public ResponseEntity<String> deleteSandwich(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteSandwich(id));
    }
}