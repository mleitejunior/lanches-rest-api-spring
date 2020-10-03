package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.enums.IngredientType;
import com.mleitejunior.lanchesrestapispring.model.Sandwich;
import com.mleitejunior.lanchesrestapispring.model.SandwichItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionService {
    private static double DISCOUNTQUANTITYPROMOTION = 10;

    public double getValuePromotionDiscount(Sandwich sandwich) {
        double starterPrice = sandwich.getTotalPrice();

        double valueOfQuantityPromotionDiscount = generateValueOfQuantityPromotionDiscount(sandwich.getSandwichItems());

        if (isIngredientTypePromotionDiscount(sandwich.getSandwichItems())) {
            starterPrice = starterPrice * (1 - (DISCOUNTQUANTITYPROMOTION/100));
        }

        return starterPrice - valueOfQuantityPromotionDiscount;
    }

    private double generateValueOfQuantityPromotionDiscount(List<SandwichItem> sandwichItems) {

        // MELHORAR TRAZENDO DO BANCO JÁ CALCULADA A QUANTIDADE DE CADA ITEM
        List<SandwichItem> queijoItemList = sandwichItems
                .stream()
                .filter(sandwichItem -> sandwichItem.getIngredient()
                        .getIngredientType().name()
                        .equals(IngredientType.QUEIJO.name()))
                .collect(Collectors.toList());

        List<SandwichItem> carneItemList = sandwichItems
                .stream()
                .filter(sandwichItem -> sandwichItem.getIngredient()
                        .getIngredientType().name()
                        .equals(IngredientType.HAMBURGUER.name()))
                .collect(Collectors.toList());

        double totalDiscount = 0;

        if (queijoItemList.size() >= 3) {
            int quantityToDiscount = queijoItemList.size() / 3;

            double valueToDiscount = queijoItemList.get(0).getIngredientPrice() * quantityToDiscount;
            totalDiscount += valueToDiscount;
        }

        if (carneItemList.size() >= 3) {
            int quantityToDiscount = carneItemList.size() / 3;

            double valueToDiscount = carneItemList.get(0).getIngredientPrice() * quantityToDiscount;
            totalDiscount += valueToDiscount;
        }

        return totalDiscount;
    }

    private boolean isIngredientTypePromotionDiscount(List<SandwichItem> sandwichItems) {
        return sandwichItems
                .stream()
                .anyMatch(sandwichItem -> sandwichItem
                        .getIngredient()
                        .getIngredientType()
                        .name()
                        .equals(IngredientType.ALFACE.name())) &&
                sandwichItems.stream()
                        .noneMatch(sandwichItem -> sandwichItem
                                .getIngredient()
                                .getIngredientType()
                                .name()
                                .equals(IngredientType.BACON.name()));
    }
}
