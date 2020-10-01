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
@Table(name = "item_order")
public class ItemOrder {

    @Id
    @GeneratedValue
    private int id;


    private List<IngredientQuantity> ingredientQuantityList;
    private double totalPrice;
}
