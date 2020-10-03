package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.model.SaleItem;
import com.mleitejunior.lanchesrestapispring.model.SandwichRecipe;
import com.mleitejunior.lanchesrestapispring.repository.SaleItemRepository;
import com.mleitejunior.lanchesrestapispring.repository.SandwichRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleItemService {

    @Autowired
    private SaleItemRepository repository;

    public SaleItem saveSaleItem(SaleItem saleItem) {
        return repository.save(saleItem);
    }

    public List<SaleItem> saveSaleItems(List<SaleItem> saleItems) {
        return repository.saveAll(saleItems);
    }

    public List<SaleItem> getSaleItems() {
        return repository.findAll();
    }

    public List<SaleItem> findAllSalePriceBySaleId(int id) {
        return repository.findAllSaleItemsBySaleId(id);
    }

    public SaleItem getSaleItemById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteSaleItem(int id) {
        repository.deleteById(id);

        return "SaleItem removed : " + id;
    }

    private float getSaleItemsTotalPrice() {
        float total = 0;

        return total;
    }
}
