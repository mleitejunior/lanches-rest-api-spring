package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.model.Sale;
import com.mleitejunior.lanchesrestapispring.model.SaleItem;
import com.mleitejunior.lanchesrestapispring.repository.SaleItemRepository;
import com.mleitejunior.lanchesrestapispring.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public Sale saveSale(Sale sale) {
        return repository.save(sale);
    }

    public List<Sale> getSales() {
        return repository.findAll();
    }

    public Sale getSaleById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteSale(int id) {
        repository.deleteById(id);

        return "Sale removed : " + id;
    }
}
