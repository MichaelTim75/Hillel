package edu.hillel.lesson23.factory;

import lombok.Getter;

@Getter
public class Store {
    public Store(FactoryI factory) {
        this.factory = factory;
    }
    private final FactoryI factory;

}
