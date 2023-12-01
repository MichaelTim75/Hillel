package edu.hillel.lesson30.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class NewsResponse {
    private List<String> news;
}
