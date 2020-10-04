package com.mleitejunior.lanchesrestapispring.repository;

import com.mleitejunior.lanchesrestapispring.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
