package edu.hillel.lesson38.service;

import edu.hillel.lesson38.dao.OrderProductRepository;
import edu.hillel.lesson38.dao.OrderRepository;
import edu.hillel.lesson38.dao.ProductRepository;
import edu.hillel.lesson38.dto.Order;
import edu.hillel.lesson38.dto.OrderProduct;
import edu.hillel.lesson38.dto.Product;
import edu.hillel.lesson38.model.OrderProductResponse;
import edu.hillel.lesson38.model.OrderRequest;
import edu.hillel.lesson38.model.OrderResponse;
import edu.hillel.lesson38.model.ProductRequest;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

@Service
public class OrderService {

    @Setter(onMethod_ = @Autowired)
    private OrderRepository orderRepository;

    @Setter(onMethod_ = @Autowired)
    private ProductRepository productRepository;

    @Setter(onMethod_ = @Autowired)
    private OrderProductRepository orderProductRepository;

    @Transactional
    public int addOrder(OrderRequest orderRequest) {
        Order order = orderRepository.save(Order.builder()
                .date(orderRequest.getDate())
                .build());
        orderRequest.getProducts().stream()
                .filter(c -> productRepository.existsById(c.getId()))
                .collect(groupingBy(ProductRequest::getId, summingInt(ProductRequest::getCount)))
                .forEach((key, value) -> {
                    OrderProduct orderProduct = OrderProduct.builder()
                            .id(new OrderProduct.OrderProductKey(order.getId(), key))
                            .order(order)
                            .product(productRepository.getReferenceById(key))
                            .cnt(value)
                            .build();
                    orderProductRepository.save(orderProduct);
                });

        return order.getId();
    }

    public List<OrderResponse> getOrders() {
        return orderRepository.findAll().stream()
                .map(o -> getOrderResponse(o, orderProductRepository.getAllByOrderId(o.getId())))
                .toList();
    }

    private OrderResponse getOrderResponse(Order o, List<OrderProduct> orderProducts) {
        return new OrderResponse(o.getId(), o.getDate(),
                orderProducts.stream()
                        .map(c -> {
                            Product product = productRepository.getReferenceById(c.getProduct().getId());
                            return new OrderProductResponse(product.getId(),
                                    product.getName(),
                                    product.getCost(),
                                    c.getCnt()
                            );
                        })
                        .collect(Collectors.toMap(OrderProductResponse::getId, c -> c))
        );
    }

    public OrderResponse getOrder(int id) {
        Order order = orderRepository.getReferenceById(id);
        return getOrderResponse(order, orderProductRepository.getAllByOrderId(id));
    }
}
