package com.mleitejunior.lanchesrestapispring.repository;

import com.mleitejunior.lanchesrestapispring.model.SandwichItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SandwichItemRepository extends JpaRepository<SandwichItem, Integer> {

    List<SandwichItem> findAllSandwichItemsBySandwichId(int id);
}
