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

    public List<Ingredient> saveIngredient(List<Ingredient> ingredients) {
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

        return "Ingredient removed : " + id;
    }

}
