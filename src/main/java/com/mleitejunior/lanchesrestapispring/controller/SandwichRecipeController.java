package com.mleitejunior.lanchesrestapispring.controller;

import com.mleitejunior.lanchesrestapispring.model.SandwichRecipe;
import com.mleitejunior.lanchesrestapispring.service.SandwichRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SandwichRecipeController {

    @Autowired
    private SandwichRecipeService service;

    @PostMapping("/sandwich_recipe")
    public SandwichRecipe addSandwichRecipe(@RequestBody SandwichRecipe sandwichRecipe) {
        return service.saveSandwichRecipe(sandwichRecipe);
    }

    @GetMapping("/sandwich_recipes")
    public List<SandwichRecipe> findAllSandwichRecipes() {
        return service.getSandwichRecipes();
    }

    @GetMapping("/sandwich_recipe/id/{id}")
    public SandwichRecipe findSandwichRecipeById(@PathVariable int id) {
        return service.getSandwichRecipeById(id);
    }

    @GetMapping("/sandwich_recipe/name/{name}")
    public SandwichRecipe findSandwichRecipeByName(@PathVariable String name) {
        return service.getSandwichRecipeByName(name);
    }

    @PutMapping("/sandwich_recipe/update")
    public SandwichRecipe updateIngredient(@RequestBody SandwichRecipe sandwichRecipe) {
        return service.updateSandwichRecipe(sandwichRecipe);
    }

    @DeleteMapping("/sandwich_recipe/{id}")
    public String deleteIngredient(@PathVariable int id) {
        return service.deleteSandwichRecipe(id);
    }
}