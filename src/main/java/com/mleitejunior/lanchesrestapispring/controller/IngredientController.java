package com.mleitejunior.lanchesrestapispring.controller;

import com.mleitejunior.lanchesrestapispring.model.Ingredient;
import com.mleitejunior.lanchesrestapispring.service.IngredientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IngredientController {

    @Autowired
    private IngredientService service;

    @ApiOperation(value = "Add a Ingredient",
            notes = "Add a Ingredient using Name, Cost or Type",
            response = Ingredient.class)
    @PostMapping("/ingredient")
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(service.saveIngredient(ingredient));
    }

    @ApiOperation(value = "Add a list of Ingredients",
            notes = "Add any number of Ingredients",
            response = List.class)
    @PostMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> addIngredients(@RequestBody List<Ingredient> ingredients) {
        return ResponseEntity.ok(service.saveIngredients(ingredients));
    }

    @ApiOperation(value = "Get the list of all Ingredients",
            notes = "Returns all Ingredients with theirs attributes",
            response = List.class)
    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> findAllIngredients() {
        return ResponseEntity.ok(service.getIngredients());
    }

    @GetMapping("/ingredient/{id}")
    public ResponseEntity<Ingredient> findIngredientById(@PathVariable int id) {
        return ResponseEntity.ok(service.getIngredientById(id));
    }

    @GetMapping("/ingredient/name/{name}")
    public ResponseEntity<Ingredient> findIngredientByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getIngredientByName(name));
    }

    @DeleteMapping("/ingredient/{id}")
    public ResponseEntity<String> deleteIngredient(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteIngredient(id));
    }
}