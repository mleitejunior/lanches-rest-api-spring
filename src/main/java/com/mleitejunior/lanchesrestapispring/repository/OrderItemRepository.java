package com.mleitejunior.lanchesrestapispring.repository;

import com.mleitejunior.lanchesrestapispring.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    List<OrderItem> findAllOrderItemsByOrderId(int id);
}
