package edu.hillel.lesson24.v1;

import java.util.List;

public interface Storage {

    void saveData(List<String> data);

    List<String> getData();

    void clearData();
}