package com.mleitejunior.lanchesrestapispring.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sale_id")
    private Integer id;

    @Column
    private Double totalPrice;

    @OneToMany(mappedBy = "sale")
    @JsonIgnore
    private List<SaleItem> saleItems;

    // NAO SALVA NO BANCO
    @Transient
    private SandwichRecipe sandwichRecipe;
}
