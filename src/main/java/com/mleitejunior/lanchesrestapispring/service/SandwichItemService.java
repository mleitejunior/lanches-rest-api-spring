package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.model.Ingredient;
import com.mleitejunior.lanchesrestapispring.model.Sandwich;
import com.mleitejunior.lanchesrestapispring.model.SandwichItem;
import com.mleitejunior.lanchesrestapispring.repository.IngredientRepository;
import com.mleitejunior.lanchesrestapispring.repository.SandwichItemRepository;
import com.mleitejunior.lanchesrestapispring.repository.SandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SandwichItemService {

    @Autowired
    private SandwichItemRepository repository;

    @Autowired
    private SandwichRepository sandwichRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private PromotionService promotionService;

    public SandwichItem saveSandwichItem(SandwichItem sandwichItem) {
        Ingredient ingredient = ingredientRepository
                .findById(sandwichItem.getIngredient().getId())
                .orElseThrow(EntityNotFoundException::new);

        sandwichItem.setIngredient(ingredient);
        sandwichItem.setIngredientPrice(ingredient.getCostPerItem());
        repository.save(sandwichItem);
        Sandwich sandwich = sandwichRepository.findById(sandwichItem.getSandwich().getId()).orElseThrow(EntityNotFoundException::new);

        List<SandwichItem> sandwichItems = repository.findAllSandwichItemsBySandwichId(sandwich.getId());

        updateSandwichTotalPrice(sandwich, sandwichItems);

        return repository.findById(sandwichItem.getId()).orElseThrow(EntityNotFoundException::new);
    }

    public List<SandwichItem> saveSandwichItems(List<SandwichItem> sandwichItems, Sandwich sandwich) {
        sandwich.setSandwichItems(repository.saveAll(sandwichItems));

        updateSandwichTotalPrice(sandwich, sandwichItems);

        return sandwichItems;
    }

    public List<SandwichItem> getSandwichItems() {
        return repository.findAll();
    }

    public List<SandwichItem> findAllSandwichPriceBySandwichId(int id) { return repository.findAllSandwichItemsBySandwichId(id); }

    public SandwichItem getSandwichItemById(int id) {
        return repository.findById(id).orElse(null);
    }

    public SandwichItem deleteSandwichItem(int id) {
        SandwichItem sandwichItem = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        repository.deleteById(id);

        List<SandwichItem> sandwichItems = repository.findAllSandwichItemsBySandwichId(sandwichItem.getSandwich().getId());

        updateSandwichTotalPrice(sandwichItem.getSandwich(), sandwichItems);

        return sandwichItem;
    }

    private void updateSandwichTotalPrice(Sandwich sandwich, List<SandwichItem> sandwichItems) {

        double totalCost = sandwichItems
                .stream()
                .map(SandwichItem::getIngredientPrice)
                .reduce(0.0, (subtotal, valor) -> subtotal + valor);

        sandwich.setTotalPrice(totalCost);

        sandwich.setTotalPrice(promotionService.getValuePromotionDiscount(sandwich));

        sandwichRepository.save(sandwich);
    }
}
