package edu.hillel.lesson29.service;

import edu.hillel.lesson29.dao.OrderRepository;
import edu.hillel.lesson29.dao.ProductRepository;
import edu.hillel.lesson29.model.Order;
import edu.hillel.lesson29.model.OrderProduct;
import edu.hillel.lesson29.model.OrderRequest;
import edu.hillel.lesson29.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public int addOrder(OrderRequest orderRequest) {
        Map<Integer, Integer> summaryProducts = orderRequest.getProducts()
                .stream()
                .filter(c -> productRepository.idExists(c.getId()))
                .collect(groupingBy(ProductRequest::getId, summingInt(ProductRequest::getCount)));

        Order order = new Order(orderRepository.getNextId(), orderRequest.getDate(),
                summaryProducts.entrySet().stream()
                        .collect(Collectors.toMap(
                                (Map.Entry::getKey),
                                (c -> new OrderProduct(c.getKey(),
                                        productRepository.getProductById(c.getKey()).getName(),
                                        productRepository.getProductById(c.getKey()).getCost(),
                                        c.getValue()))
                        ))
        );
        return orderRepository.addOrder(order);
    }

    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }

    public Order getOrder(int id) {
        return orderRepository.getOrderById(id);
    }
}
