package edu.hillel.lesson36.controller;

import edu.hillel.lesson36.model.Product;
import edu.hillel.lesson36.service.ProductService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    private static final Logger LOGGER = LogManager.getLogger();

    @GetMapping
    public Collection<Product> findAll() {
        LOGGER.info("Method findAll.");
        return productService.findAll();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        LOGGER.info("Method save.");
        return productService.save(product);
    }

    @GetMapping(path = "/{id}")
    public Product findById(@PathVariable Integer id) {
        LOGGER.info("Method findById with id={}.", id);
        return productService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Integer id) {
        LOGGER.info("Method deleteById with id={}.", id);
        productService.deleteById(id);
    }

}
