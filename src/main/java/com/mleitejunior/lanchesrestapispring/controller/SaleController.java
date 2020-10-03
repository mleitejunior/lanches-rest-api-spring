package com.mleitejunior.lanchesrestapispring.controller;

import com.mleitejunior.lanchesrestapispring.model.Sale;
import com.mleitejunior.lanchesrestapispring.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleController {

    @Autowired
    private SaleService service;

    @PostMapping("/sale")
    public Sale addSale(@RequestBody Sale sale) {
        return service.saveSale(sale);
    }

    @GetMapping("/sales")
    public List<Sale> findAllSales() {
        return service.getSales();
    }

    @GetMapping("/sale/{id}")
    public Sale findSaleById(@PathVariable int id) {
        return service.getSaleById(id);
    }

    @DeleteMapping("/sale/{id}")
    public String deleteSale(@PathVariable int id) {
        return service.deleteSale(id);
    }
}