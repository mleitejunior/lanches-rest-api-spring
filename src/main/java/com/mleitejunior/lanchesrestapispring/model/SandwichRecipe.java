package com.mleitejunior.lanchesrestapispring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sandwich_recipe")
public class SandwichRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sandwich_recipe_id")
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany//(cascade = CascadeType.ALL) //Tanto apaga quanto salva
    @JoinTable(
            name = "sandwich_recipe_has_ingredient",
            joinColumns = @JoinColumn(name = "sandwich_recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    List<Ingredient> ingredients;
}