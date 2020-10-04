package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.enums.IngredientType;
import com.mleitejunior.lanchesrestapispring.model.Order;
import com.mleitejunior.lanchesrestapispring.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionService {
    private static double DISCOUNTQUANTITYPROMOTION = 10;

    public double getValuePromotionDiscount(Order order) {
        double starterPrice = order.getTotalPrice();

        double valueOfQuantityPromotionDiscount = generateValueOfQuantityPromotionDiscount(order.getOrderItems());

        if (isIngredientTypePromotionDiscount(order.getOrderItems())) {
            starterPrice = starterPrice * (1 - (DISCOUNTQUANTITYPROMOTION/100));
        }

        return starterPrice - valueOfQuantityPromotionDiscount;
    }

    private double generateValueOfQuantityPromotionDiscount(List<OrderItem> orderItems) {

        // MELHORAR TRAZENDO DO BANCO JÁ CALCULADA A QUANTIDADE DE CADA ITEM
        List<OrderItem> queijoItemList = orderItems
                .stream()
                .filter(sandwichItem -> sandwichItem.getIngredient()
                        .getIngredientType().name()
                        .equals(IngredientType.QUEIJO.name()))
                .collect(Collectors.toList());

        List<OrderItem> carneItemList = orderItems
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

    private boolean isIngredientTypePromotionDiscount(List<OrderItem> orderItems) {
        return orderItems
                .stream()
                .anyMatch(sandwichItem -> sandwichItem
                        .getIngredient()
                        .getIngredientType()
                        .name()
                        .equals(IngredientType.ALFACE.name())) &&
                orderItems.stream()
                        .noneMatch(sandwichItem -> sandwichItem
                                .getIngredient()
                                .getIngredientType()
                                .name()
                                .equals(IngredientType.BACON.name()));
    }
}
