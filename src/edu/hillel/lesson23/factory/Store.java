package edu.hillel.lesson23.factory;

import lombok.Getter;

@Getter
public class Store {
    public Store(Factory factory) {
        this.factory = factory;
    }
    private final Factory factory;

}
