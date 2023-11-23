package edu.hillel.lesson29.dao;

import edu.hillel.lesson29.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    private final Map<Integer, Product> products = new HashMap<>(Map.of(
            1, new Product(1, "Bread", BigDecimal.valueOf(1.5)),
            2, new Product(2, "Milk", BigDecimal.valueOf(1.7)),
            3, new Product(3, "Sugar", BigDecimal.valueOf(2)),
            4, new Product(4, "Salt", BigDecimal.valueOf(10)),
            5, new Product(5, "Butter", BigDecimal.valueOf(0.5)),
            6, new Product(6, "Flavour", BigDecimal.valueOf(5.5))
    ));

    public Product getProductById(int id) {
        return products.get(id);
    }

    public List<Product> getProducts() {
        return products.values().stream().toList();
    }

    public boolean idExists(int id) {
        return products.containsKey(id);
    }

}
