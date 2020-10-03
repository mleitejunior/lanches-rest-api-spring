package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.model.Sale;
import com.mleitejunior.lanchesrestapispring.model.SaleItem;
import com.mleitejunior.lanchesrestapispring.model.SandwichRecipe;
import com.mleitejunior.lanchesrestapispring.repository.SaleItemRepository;
import com.mleitejunior.lanchesrestapispring.repository.SaleRepository;
import com.mleitejunior.lanchesrestapispring.repository.SandwichRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SaleItemService saleItemService;

    @Autowired
    private SandwichRecipeRepository sandwichRecipeRepository;

    public Sale saveSale(Sale sale) {
        repository.save(sale);

        if (sale.getSandwichRecipe() != null && sale.getSandwichRecipe().getId() != null) {
            SandwichRecipe sandwichRecipe = sandwichRecipeRepository
                    .findById(sale.getSandwichRecipe().getId())
                    .orElseThrow(EntityNotFoundException::new);

            if (!sandwichRecipe.getIngredients().isEmpty()) {
                List<SaleItem> saleItems = sandwichRecipe
                        .getIngredients()
                        .stream()
                        .map(ingredient -> {
                            SaleItem s = new SaleItem();
                            s.setSale(sale);
                            s.setIngredient(ingredient);
                            s.setIngredientPrice(ingredient.getCostPerItem());
                            return s;
                        })
                        .collect(Collectors.toList());

                saleItemService.saveSaleItems(saleItems, sale);
            }
        }

        return sale;
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
