package edu.hillel.lesson36.repository;

import edu.hillel.lesson36.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Override
    void deleteById(Integer id);

    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Integer id);

    @Override
    <S extends Product> S save(S entity);
}
