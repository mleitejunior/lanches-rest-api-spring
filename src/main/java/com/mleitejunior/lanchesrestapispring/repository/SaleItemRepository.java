package com.mleitejunior.lanchesrestapispring.repository;

import com.mleitejunior.lanchesrestapispring.model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleItemRepository extends JpaRepository<SaleItem, Integer> {

    List<SaleItem> findAllSaleItemsBySaleId(int id);
}
