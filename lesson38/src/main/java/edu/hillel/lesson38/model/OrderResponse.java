package edu.hillel.lesson38.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Getter
public class OrderResponse {

    private final int id;
    private final LocalDate date;
    private final BigDecimal cost;
    private final Map<Integer, OrderProductResponse> products;

    public OrderResponse(int id, LocalDate date, Map<Integer, OrderProductResponse> products) {
        this.id = id;
        this.date = date;
        this.products = products;
        this.cost = products.values()
                .stream()
                .map(OrderProductResponse::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
