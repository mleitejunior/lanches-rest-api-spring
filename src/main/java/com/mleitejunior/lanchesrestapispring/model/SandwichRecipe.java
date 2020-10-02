package com.mleitejunior.lanchesrestapispring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
