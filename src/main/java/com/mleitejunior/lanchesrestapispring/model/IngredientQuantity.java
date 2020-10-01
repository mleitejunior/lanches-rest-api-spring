package com.mleitejunior.lanchesrestapispring.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ingredient_quantity")
public class IngredientQuantity {

    private int ingredientId;
    private int quantity;

    @ManyToOne
    public int getIngredientId() {
        return ingredientId;
    }
}
