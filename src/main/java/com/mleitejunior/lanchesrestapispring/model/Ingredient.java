package com.mleitejunior.lanchesrestapispring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ingredient_id")
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private double costPerItem;
}
