package edu.hillel.lesson24.v1;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage implements Storage {

    private final List<String> data;

    public InMemoryStorage() {
        data = new ArrayList<>();

    }

    @Override
    public void saveData(List<String> data) {
        this.data.addAll(data);
    }

    @Override
    public List<String> getData() {
        return data;
    }

    @Override
    public void clearData() {
        data.clear();
    }
}