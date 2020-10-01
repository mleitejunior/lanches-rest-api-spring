package com.mleitejunior.lanchesrestapispring.controller;

import com.mleitejunior.lanchesrestapispring.model.Ingredient;
import com.mleitejunior.lanchesrestapispring.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {

    @Autowired
    private IngredientService service;

    @PostMapping("/ingredient")
    public Ingredient addProduct(@RequestBody Ingredient ingredient) {
        return service.saveIngredient(ingredient);
    }

    @PostMapping("/ingredients")
    public List<Ingredient> addIngredients(@RequestBody List<Ingredient> ingredients) {
        return service.saveIngredients(ingredients);
    }

    @GetMapping("/ingredients")
    public List<Ingredient> findAllIngredients() {
        return service.getIngredients();
    }

    @GetMapping("/ingredient/id/{id}")
    public Ingredient findIngredientById(@PathVariable int id) {
        return service.getIngredientById(id);
    }

    @GetMapping("/ingredient/name/{name}")
    public Ingredient findIngredientByName(@PathVariable String name) {
        return service.getIngredientByName(name);
    }

    @PutMapping("/ingredient/update")
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient) {
        return service.updateIngredient(ingredient);
    }

    @DeleteMapping("/ingredient/{id}")
    public String deleteIngredient(@PathVariable int id) {
        return service.deleteIngredient(id);
    }
}