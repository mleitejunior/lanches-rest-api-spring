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
@Table(name = "sandwich_recipe")
public class SandwichRecipe {

    @Id
    @GeneratedValue
    @Column(name="sandwich_recipe_id")
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "sandwich_recipe_has_ingredient",
            joinColumns = @JoinColumn(name = "sandwich_recipe_id"),
            inverseJoinColumns = { @JoinColumn(name = "ingredient_id")})
    private Set<Ingredient> ingredients = new HashSet<>();

}
