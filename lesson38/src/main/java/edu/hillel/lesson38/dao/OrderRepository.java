package edu.hillel.lesson38.dao;

import edu.hillel.lesson38.dto.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
