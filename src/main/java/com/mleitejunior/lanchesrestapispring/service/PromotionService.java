package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.enums.IngredientType;
import com.mleitejunior.lanchesrestapispring.model.Sale;
import com.mleitejunior.lanchesrestapispring.model.SaleItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionService {
    private static double DISCOUNTQUANTITYPROMOTION = 10;

    public double getValuePromotionDiscount(Sale sale) {
        double starterPrice = sale.getTotalPrice();

        double valueOfQuantityPromotionDiscount = generateValueOfQuantityPromotionDiscount(sale.getSaleItems());

        if (isIngredientTypePromotionDiscount(sale.getSaleItems())) {
            starterPrice = starterPrice * (1 - (DISCOUNTQUANTITYPROMOTION/100));
        }

        return starterPrice - valueOfQuantityPromotionDiscount;
    }

    private double generateValueOfQuantityPromotionDiscount(List<SaleItem> saleItems) {

        // MELHORAR TRAZENDO DO BANCO JÁ CALCULADA A QUANTIDADE DE CADA ITEM
        List<SaleItem> queijoItemList = saleItems
                .stream()
                .filter(saleItem -> saleItem.getIngredient()
                        .getIngredientType().name()
                        .equals(IngredientType.QUEIJO.name()))
                .collect(Collectors.toList());

        List<SaleItem> carneItemList = saleItems
                .stream()
                .filter(saleItem -> saleItem.getIngredient()
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

    private boolean isIngredientTypePromotionDiscount(List<SaleItem> saleItems) {
        return saleItems
                .stream()
                .anyMatch(saleItem -> saleItem
                        .getIngredient()
                        .getIngredientType()
                        .name()
                        .equals(IngredientType.ALFACE.name())) &&
                saleItems.stream()
                        .noneMatch(saleItem -> saleItem
                                .getIngredient()
                                .getIngredientType()
                                .name()
                                .equals(IngredientType.BACON.name()));
    }
}
