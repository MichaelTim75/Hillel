package edu.hillel.lesson28.dao;

import edu.hillel.lesson28.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    private Map<Integer, Product> products =  new HashMap<>(Map.of(
            1, new Product(1, "Bread"),
            2, new Product(2, "Milk"),
            3, new Product(3, "Sugar"),
            4, new Product(4, "Salt"),
            5, new Product(5, "Butter"),
            6, new Product(6, "Flavour")
    ));

    public Product getProductById(int id){
        return products.get(id);
    }

    public List<Product> getProducts(){
        return products.values().stream().toList();
    }

}
