package com.mleitejunior.lanchesrestapispring;

import com.mleitejunior.lanchesrestapispring.model.Ingredient;
import com.mleitejunior.lanchesrestapispring.model.SandwichRecipe;
import com.mleitejunior.lanchesrestapispring.repository.IngredientRepository;
import com.mleitejunior.lanchesrestapispring.repository.SandwichRecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JdbcTests {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private SandwichRecipeRepository sandwichRecipeRepository;

    @Test
    public void testRelationships() {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("repolho");
        ingredient.setCostPerItem(0.4);

        ingredientRepository.save(ingredient);

        SandwichRecipe sandwichRecipe = new SandwichRecipe();
        sandwichRecipe.setName("x-repolho");
        sandwichRecipe.addIngredient(ingredient);

        sandwichRecipeRepository.save(sandwichRecipe);

        for (SandwichRecipe sr : sandwichRecipeRepository.findAll()) {
            System.out.println(ingredientRepository.findAllById(sr.getIngredientIds()));
        }
    }
}
