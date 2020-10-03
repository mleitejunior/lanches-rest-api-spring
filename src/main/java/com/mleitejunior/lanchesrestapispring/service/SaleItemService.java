package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.model.Ingredient;
import com.mleitejunior.lanchesrestapispring.model.Sale;
import com.mleitejunior.lanchesrestapispring.model.SaleItem;
import com.mleitejunior.lanchesrestapispring.repository.IngredientRepository;
import com.mleitejunior.lanchesrestapispring.repository.SaleItemRepository;
import com.mleitejunior.lanchesrestapispring.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SaleItemService {

    @Autowired
    private SaleItemRepository repository;

    @Autowired
    private SaleRepository salesRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private PromotionService promotionService;

    public SaleItem saveSaleItem(SaleItem saleItem) {
        Ingredient ingredient = ingredientRepository
                .findById(saleItem.getIngredient().getId())
                .orElseThrow(EntityNotFoundException::new);

        saleItem.setIngredient(ingredient);
        saleItem.setIngredientPrice(ingredient.getCostPerItem());
        repository.save(saleItem);
        Sale sale = salesRepository.findById(saleItem.getSale().getId()).orElseThrow(EntityNotFoundException::new);

        List<SaleItem> saleItems = repository.findAllSaleItemsBySaleId(sale.getId());

        updateSaleTotalPrice(sale, saleItems);

        return repository.findById(saleItem.getId()).orElseThrow(EntityNotFoundException::new);
    }

    public List<SaleItem> saveSaleItems(List<SaleItem> saleItems, Sale sale) {
        sale.setSaleItems(repository.saveAll(saleItems));

        updateSaleTotalPrice(sale, saleItems);

        return saleItems;
    }

    public List<SaleItem> getSaleItems() {
        return repository.findAll();
    }

    public List<SaleItem> findAllSalePriceBySaleId(int id) { return repository.findAllSaleItemsBySaleId(id); }

    public SaleItem getSaleItemById(int id) {
        return repository.findById(id).orElse(null);
    }

    public SaleItem deleteSaleItem(int id) {
        SaleItem saleItem = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        repository.deleteById(id);

        List<SaleItem> saleItems = repository.findAllSaleItemsBySaleId(saleItem.getSale().getId());

        updateSaleTotalPrice(saleItem.getSale(), saleItems);

        return saleItem;
    }

    private void updateSaleTotalPrice(Sale sale, List<SaleItem> saleItems) {

        double totalCost = saleItems
                .stream()
                .map(SaleItem::getIngredientPrice)
                .reduce(0.0, (subtotal, valor) -> subtotal + valor);

        sale.setTotalPrice(totalCost);

        sale.setTotalPrice(promotionService.getValuePromotionDiscount(sale));

        salesRepository.save(sale);
    }
}
