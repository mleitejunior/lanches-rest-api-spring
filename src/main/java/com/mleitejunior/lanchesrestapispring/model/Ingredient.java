package com.mleitejunior.lanchesrestapispring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue
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
    private Set<SandwichRecipe> sandwichRecipes = new HashSet<>();

}
