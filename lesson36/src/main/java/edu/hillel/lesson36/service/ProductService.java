package edu.hillel.lesson36.service;

import edu.hillel.lesson36.model.Product;
import edu.hillel.lesson36.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product id="+id+" not found!"));
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

}
