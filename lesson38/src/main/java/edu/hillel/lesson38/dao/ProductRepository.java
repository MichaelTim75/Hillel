package edu.hillel.lesson38.dao;

import edu.hillel.lesson38.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
