package edu.hillel.lesson21.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Lesson {
    private int id;
    private final String name;
    private String homework;
    private final int homeworkId;

    public Lesson(String name, int homeworkId) {
        this.name = name;
        this.homeworkId = homeworkId;
    }
}
