package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.model.Ingredient;
import com.mleitejunior.lanchesrestapispring.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Ingredient updateIngredient(Ingredient ingredient) {
        if (repository.findById(ingredient.getId()) != null) {
            return repository.save(ingredient);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found");
    }

    public Ingredient getIngredientByName(String name) {
        return repository.findByName(name);
    }

    public String deleteIngredient(int id) {
        repository.deleteById(id);

        return "Ingredient removed : " + id;
    }

}
