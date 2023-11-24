package edu.hillel.lesson29.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OrderProduct extends Product {
    private final int count;

    public OrderProduct(int id, String name, BigDecimal cost, int count) {
        super(id, name);
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
