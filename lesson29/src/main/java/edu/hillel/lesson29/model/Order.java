package edu.hillel.lesson29.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Getter
public class Order {

    private final int id;
    private final LocalDate date;
    private final BigDecimal cost;
    private final Map<Integer, OrderProduct> products;

    public Order(int id, LocalDate date, Map<Integer, OrderProduct> products) {
        this.id = id;
        this.date = date;
        this.products = products;
        this.cost = products.values()
                .stream().map(Product::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
