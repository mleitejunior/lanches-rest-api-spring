package com.mleitejunior.lanchesrestapispring.controller;

import com.mleitejunior.lanchesrestapispring.model.SaleItem;
import com.mleitejunior.lanchesrestapispring.model.SandwichRecipe;
import com.mleitejunior.lanchesrestapispring.service.SaleItemService;
import com.mleitejunior.lanchesrestapispring.service.SandwichRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleItemController {

    @Autowired
    private SaleItemService service;

    @PostMapping("/sale_item")
    public SaleItem addSaleItem(@RequestBody SaleItem saleItem) {
        return service.saveSaleItem(saleItem);
    }

    @PostMapping("/sale_items")
    public List<SaleItem> addSaleItems(@RequestBody List<SaleItem> saleItems) {
        return service.saveSaleItems(saleItems);
    }

    @GetMapping("/sale_items")
    public List<SaleItem> findAllSaleItems() {
        return service.getSaleItems();
    }

    @GetMapping("/sale_item/{id}")
    public SaleItem findSaleItemById(@PathVariable int id) {
        return service.getSaleItemById(id);
    }

    @GetMapping("/sale_items/sale/{id}")
    public List<SaleItem> findAllSaleItemsBySaleId(@PathVariable int id) {
        return service.findAllSalePriceBySaleId(id);
    }

    @DeleteMapping("/sale_item/{id}")
    public String deleteSaleItem(@PathVariable int id) {
        return service.deleteSaleItem(id);
    }
}