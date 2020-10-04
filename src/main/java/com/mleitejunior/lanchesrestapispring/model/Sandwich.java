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
@Table(name = "tbl_sandwich")
public class Sandwich {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tbl_sandwich_id")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "tbl_sandwich_has_ingredient",
            joinColumns = @JoinColumn(name = "tbl_sandwich_id"),
            inverseJoinColumns = @JoinColumn(name = "tbl_ingredient_id"))
    List<Ingredient> ingredients;
}