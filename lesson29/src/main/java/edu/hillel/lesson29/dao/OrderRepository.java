package edu.hillel.lesson29.dao;

import edu.hillel.lesson29.model.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {
    private final Map<Integer, Order> orders = new HashMap<>();

    public int getNextId() {
        return orders
                .keySet()
                .stream()
                .max(Integer::compareTo)
                .orElseGet(() -> 1);
    }

    public int addOrder(Order order) {
        orders.put(order.getId(), order);
        return order.getId();
    }


    public Order getOrderById(int id) {
        return orders.get(id);
    }

    public List<Order> getOrders() {
        return orders.values().stream().toList();
    }

}
