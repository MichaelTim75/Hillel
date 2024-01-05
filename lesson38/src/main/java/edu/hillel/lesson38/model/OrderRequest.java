package edu.hillel.lesson38.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderRequest {

    private LocalDate date;
    private List<ProductRequest> products;

}
