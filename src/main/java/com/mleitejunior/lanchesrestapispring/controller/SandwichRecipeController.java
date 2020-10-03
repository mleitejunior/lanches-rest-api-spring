package com.mleitejunior.lanchesrestapispring.controller;

import com.mleitejunior.lanchesrestapispring.model.SandwichRecipe;
import com.mleitejunior.lanchesrestapispring.service.SandwichRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SandwichRecipeController {

    @Autowired
    private SandwichRecipeService service;

    @PostMapping("/sandwich_recipe")
    public ResponseEntity<SandwichRecipe> addSandwichRecipe(@RequestBody SandwichRecipe sandwichRecipe) {
        return ResponseEntity.ok(service.saveSandwichRecipe(sandwichRecipe));
    }

    @PostMapping("/sandwich_recipes")
    public ResponseEntity<List<SandwichRecipe>> addSandwichRecipes(@RequestBody List<SandwichRecipe> sandwichRecipes) {
        return ResponseEntity.ok(service.saveSandwichRecipes(sandwichRecipes));
    }

    @GetMapping("/sandwich_recipes")
    public ResponseEntity<List<SandwichRecipe>> findAllSandwichRecipes() {
        return ResponseEntity.ok(service.getSandwichRecipes());
    }

    @GetMapping("/sandwich_recipe/{id}")
    public ResponseEntity<SandwichRecipe> findSandwichRecipeById(@PathVariable int id) {
        return ResponseEntity.ok(service.getSandwichRecipeById(id));
    }

    @GetMapping("/sandwich_recipe/name/{name}")
    public ResponseEntity<SandwichRecipe> findSandwichRecipeByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getSandwichRecipeByName(name));
    }

    @DeleteMapping("/sandwich_recipe/{id}")
    public ResponseEntity<String> deleteIngredient(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteSandwichRecipe(id));
    }
}