package edu.hillel.lesson28.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
public class CartProduct extends Product{
    private final int count;

    public CartProduct(int id, String name, int count) {
        super(id, name);
        this.count=count;
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
