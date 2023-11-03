package edu.hillel.lesson21.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Homework {
    private  int id;
    private final String name;
    private final String description;

    public Homework(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
