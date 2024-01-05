package edu.hillel.lesson38.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OrderProductResponse {
    protected final int id;
    protected final String name;
    protected BigDecimal cost;
    private final int count;

    public OrderProductResponse(int id, String name, BigDecimal cost, int count) {
        this.id = id;
        this.name = name;
        this.cost = cost.multiply(BigDecimal.valueOf(count));
        this.count = count;
    }

    @Override
    public String toString() {
        return "CartProduct{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", cost=" + cost +
               ", count=" + count +
               '}';
    }
}
