package com.mleitejunior.lanchesrestapispring.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tbl_order_item_id")
    private Integer id;

    @Column
    private Double ingredientPrice;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tbl_ingredient_id", nullable = false)
    private Ingredient ingredient;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tbl_order_id", nullable = false)
    private Order order;
}
