package com.mleitejunior.lanchesrestapispring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ingredient_id")
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private double costPerItem;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "sandwich_recipe_has_ingredient",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = { @JoinColumn(name = "sandwich_recipe_id")})
    private List<SandwichRecipe> sandwichRecipes = new ArrayList<>();

    public void addSandwichRecipe(SandwichRecipe sandwichRecipe) {
        this.sandwichRecipes.add(sandwichRecipe);
    }

    public List<Integer> getSandwichRecipeIds() {
        return this.sandwichRecipes.stream()
                .map(SandwichRecipe::getId)
                .collect(Collectors.toList());
    }
}
