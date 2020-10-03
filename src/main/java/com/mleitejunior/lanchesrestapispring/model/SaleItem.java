package com.mleitejunior.lanchesrestapispring.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sale_item")
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sale_item_id")
    private Integer id;

    @Column
    private Double ingredientPrice;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;
}