package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.model.Ingredient;
import com.mleitejunior.lanchesrestapispring.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository repository;

    public Ingredient saveIngredient(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public List<Ingredient> saveIngredients(List<Ingredient> ingredients) {
        return repository.saveAll(ingredients);
    }

    public List<Ingredient> getIngredients() {
        return repository.findAll();
    }

    public Ingredient getIngredientById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Ingredient getIngredientByName(String name) {
        return repository.findByName(name);
    }

    public String deleteIngredient(int id) {
        repository.deleteById(id);

        return "Product removed : " + id;
    }

    public Ingredient updateIngredient(Ingredient ingredient) {
        Ingredient existingIngredient = repository.findById(ingredient.getId()).orElse(null);

        existingIngredient.setName(ingredient.getName());
        existingIngredient.setCostPerItem(ingredient.getCostPerItem());

        return repository.save(existingIngredient);
    }
}
