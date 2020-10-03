package com.mleitejunior.lanchesrestapispring.repository;

import com.mleitejunior.lanchesrestapispring.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
