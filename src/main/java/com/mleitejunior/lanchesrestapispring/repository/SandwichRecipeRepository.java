package com.mleitejunior.lanchesrestapispring.repository;

import com.mleitejunior.lanchesrestapispring.model.SandwichRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SandwichRecipeRepository extends JpaRepository<SandwichRecipe, Integer> {

    SandwichRecipe findByName(String name);
}
