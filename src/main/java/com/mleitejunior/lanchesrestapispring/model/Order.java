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
@Table(name = "tbl_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tbl_order_id")
    private Integer id;

    @Column
    private Double totalPrice;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<OrderItem> orderItems;

    @Transient
    private Sandwich sandwich;
}
