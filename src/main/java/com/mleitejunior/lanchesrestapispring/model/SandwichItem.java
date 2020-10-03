package com.mleitejunior.lanchesrestapispring.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sandwich_item")
public class SandwichItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sandwich_item_id")
    private Integer id;

    @Column
    private Double ingredientPrice;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sandwich_id", nullable = false)
    private Sandwich sandwich;
}
