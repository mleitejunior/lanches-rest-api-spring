package com.mleitejunior.lanchesrestapispring.service;

import com.mleitejunior.lanchesrestapispring.model.Ingredient;
import com.mleitejunior.lanchesrestapispring.model.Order;
import com.mleitejunior.lanchesrestapispring.model.OrderItem;
import com.mleitejunior.lanchesrestapispring.repository.IngredientRepository;
import com.mleitejunior.lanchesrestapispring.repository.OrderItemRepository;
import com.mleitejunior.lanchesrestapispring.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private PromotionService promotionService;

    public OrderItem saveOrderItem(OrderItem orderItem) {
        Ingredient ingredient = ingredientRepository
                .findById(orderItem.getIngredient().getId())
                .orElseThrow(EntityNotFoundException::new);

        orderItem.setIngredient(ingredient);
        orderItem.setIngredientPrice(ingredient.getCostPerItem());
        repository.save(orderItem);
        Order order = orderRepository.findById(orderItem.getOrder().getId()).orElseThrow(EntityNotFoundException::new);

        List<OrderItem> orderItems = repository.findAllOrderItemsByOrderId(order.getId());

        updateOrderTotalPrice(order, orderItems);

        return repository.findById(orderItem.getId()).orElseThrow(EntityNotFoundException::new);
    }

    public List<OrderItem> saveOrderItem(List<OrderItem> orderItems, Order order) {
        order.setOrderItems(repository.saveAll(orderItems));

        updateOrderTotalPrice(order, orderItems);

        return orderItems;
    }

    public List<OrderItem> getOrderItems() {
        return repository.findAll();
    }

    public List<OrderItem> findAllOrderItemsByOrderId(int id) { return repository.findAllOrderItemsByOrderId(id); }

    public OrderItem getOrderItemById(int id) {
        return repository.findById(id).orElse(null);
    }

    public OrderItem deleteOrderItem(int id) {
        OrderItem orderItem = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        repository.deleteById(id);

        List<OrderItem> orderItems = repository.findAllOrderItemsByOrderId(orderItem.getOrder().getId());

        updateOrderTotalPrice(orderItem.getOrder(), orderItems);

        return orderItem;
    }

    public OrderItem updateOrderItem(OrderItem orderItem) {
        if (repository.findById(orderItem.getId()) != null) {
            return repository.save(orderItem);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "OrderItem not found");
    }

    private void updateOrderTotalPrice(Order order, List<OrderItem> orderItems) {

        double totalCost = orderItems
                .stream()
                .map(OrderItem::getIngredientPrice)
                .reduce(0.0, (subtotal, valor) -> subtotal + valor);

        order.setTotalPrice(totalCost);

        order.setTotalPrice(promotionService.getValuePromotionDiscount(order));

        orderRepository.save(order);
    }
}
