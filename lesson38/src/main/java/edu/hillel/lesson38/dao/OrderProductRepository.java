package edu.hillel.lesson38.dao;

import edu.hillel.lesson38.dto.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProduct.OrderProductKey> {

    List<OrderProduct> getAllByOrderId(int id);
}
