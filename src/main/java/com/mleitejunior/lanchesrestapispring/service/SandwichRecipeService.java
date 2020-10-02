package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.model.Ingredient;
import com.mleitejunior.lanchesrestapispring.model.Sandwich;
import com.mleitejunior.lanchesrestapispring.model.SandwichRecipe;
import com.mleitejunior.lanchesrestapispring.repository.IngredientRepository;
import com.mleitejunior.lanchesrestapispring.repository.SandwichRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichRecipeService {

    @Autowired
    private SandwichRecipeRepository repository;

    public SandwichRecipe saveSandwichRecipe(SandwichRecipe sandwichRecipe) {
        return repository.save(sandwichRecipe);
    }

    public List<SandwichRecipe> getSandwichRecipes() {
        return repository.findAll();
    }

    public SandwichRecipe getSandwichRecipeById(int id) {
        return repository.findById(id).orElse(null);
    }

    public SandwichRecipe getSandwichRecipeByName(String name) {
        return repository.findByName(name);
    }

    public String deleteSandwichRecipe(int id) {
        repository.deleteById(id);

        return "SandwichRecipe removed : " + id;
    }

    public SandwichRecipe updateSandwichRecipe(SandwichRecipe sandwichRecipe) {
        SandwichRecipe existingSandwichRecipe = repository.findById(sandwichRecipe.getId()).orElse(null);

        existingSandwichRecipe.setName(sandwichRecipe.getName());

        return repository.save(existingSandwichRecipe);
    }
}
