package edu.hillel.lesson29.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderRequest {

    private LocalDate date;
    private List<ProductRequest> products;

}
