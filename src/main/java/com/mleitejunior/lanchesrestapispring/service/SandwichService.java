package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.model.Sandwich;
import com.mleitejunior.lanchesrestapispring.model.SandwichItem;
import com.mleitejunior.lanchesrestapispring.model.SandwichRecipe;
import com.mleitejunior.lanchesrestapispring.repository.SandwichRepository;
import com.mleitejunior.lanchesrestapispring.repository.SandwichRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SandwichService {

    @Autowired
    private SandwichRepository repository;

    @Autowired
    private SandwichItemService sandwichItemService;

    @Autowired
    private SandwichRecipeRepository sandwichRecipeRepository;

    public Sandwich saveSandwich(Sandwich sandwich) {
        repository.save(sandwich);

        if (sandwich.getSandwichRecipe() != null && sandwich.getSandwichRecipe().getId() != null) {
            SandwichRecipe sandwichRecipe = sandwichRecipeRepository
                    .findById(sandwich.getSandwichRecipe().getId())
                    .orElseThrow(EntityNotFoundException::new);

            if (!sandwichRecipe.getIngredients().isEmpty()) {
                List<SandwichItem> sandwichItems = sandwichRecipe
                        .getIngredients()
                        .stream()
                        .map(ingredient -> {
                            SandwichItem s = new SandwichItem();
                            s.setSandwich(sandwich);
                            s.setIngredient(ingredient);
                            s.setIngredientPrice(ingredient.getCostPerItem());
                            return s;
                        })
                        .collect(Collectors.toList());

                sandwichItemService.saveSandwichItems(sandwichItems, sandwich);
            }
        }

        return sandwich;
    }

    public List<Sandwich> getSandwiches() {
        return repository.findAll();
    }

    public Sandwich getSandwichById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteSandwich(int id) {
        repository.deleteById(id);

        return "Sandwich removed : " + id;
    }
}
