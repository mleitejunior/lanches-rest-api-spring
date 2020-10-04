package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.model.Order;
import com.mleitejunior.lanchesrestapispring.model.OrderItem;
import com.mleitejunior.lanchesrestapispring.model.Sandwich;
import com.mleitejunior.lanchesrestapispring.repository.OrderRepository;
import com.mleitejunior.lanchesrestapispring.repository.SandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private SandwichRepository sandwichRepository;

    public Order saveOrder(Order order) {
        repository.save(order);

        if (order.getSandwich() != null && order.getSandwich().getId() != null) {
            Sandwich sandwich = sandwichRepository
                    .findById(order.getSandwich().getId())
                    .orElseThrow(EntityNotFoundException::new);

            if (!sandwich.getIngredients().isEmpty()) {
                List<OrderItem> orderItems = sandwich
                        .getIngredients()
                        .stream()
                        .map(ingredient -> {
                            OrderItem s = new OrderItem();
                            s.setOrder(order);
                            s.setIngredient(ingredient);
                            s.setIngredientPrice(ingredient.getCostPerItem());
                            return s;
                        })
                        .collect(Collectors.toList());

                orderItemService.saveOrderItem(orderItems, order);
            }
        }

        return order;
    }

    public List<Order> getOrders() {
        return repository.findAll();
    }

    public Order getOrderById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteOrder(int id) {
        repository.deleteById(id);

        return "Order removed : " + id;
    }
}
