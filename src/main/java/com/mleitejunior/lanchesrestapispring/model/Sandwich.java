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
@Table(name = "sandwich")
public class Sandwich {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sandwich_id")
    private Integer id;

    @Column
    private Double totalPrice;

    @OneToMany(mappedBy = "sandwich")
    @JsonIgnore
    private List<SandwichItem> sandwichItems;

    @Transient
    private SandwichRecipe sandwichRecipe;
}
