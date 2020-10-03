package com.mleitejunior.lanchesrestapispring.controller;

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

    @GetMapping("/sandwiches")
    public ResponseEntity<List<Sandwich>> findAllSandwiches() {
        return ResponseEntity.ok(service.getSandwiches());
    }

    @GetMapping("/sandwich/{id}")
    public ResponseEntity<Sandwich> findSandwichById(@PathVariable int id) {
        return ResponseEntity.ok(service.getSandwichById(id));
    }

    @DeleteMapping("/sandwich/{id}")
    public ResponseEntity<String> deleteSandwich(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteSandwich(id));
    }
}