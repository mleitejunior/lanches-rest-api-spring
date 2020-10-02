package com.mleitejunior.lanchesrestapispring.model;

import javax.persistence.*;

@Entity
@Table(name = "sandwich")
public class Sandwich {

    @Id
    @GeneratedValue
    @Column(name = "sandwich_id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "sandwich_recipe_id")
    private SandwichRecipe sandwich;
}
