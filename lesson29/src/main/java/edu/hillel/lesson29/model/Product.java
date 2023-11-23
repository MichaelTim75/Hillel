package edu.hillel.lesson29.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
@ToString
@Setter
public class Product {
    protected final int id;
    protected final String name;
    protected BigDecimal cost;

    public Product(int id, String name, BigDecimal cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
}
