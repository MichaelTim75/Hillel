package edu.hillel.lesson38.controller;

import edu.hillel.lesson38.model.AddOrderResponse;
import edu.hillel.lesson38.model.OrderRequest;
import edu.hillel.lesson38.model.OrderResponse;
import edu.hillel.lesson38.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
@Tag(name = "Order API", description = "API for working with orders")
@Slf4j
public class OrderController {

    @Setter(onMethod_ = @Autowired)
    private OrderService orderService;

    @Operation(summary = "Service for getting all orders")
    @GetMapping
    public List<OrderResponse> getOrders() {
        log.info("Run get orders");
        return orderService.getOrders();
    }

    @Operation(summary = "Service for getting order by id")
    @GetMapping(path = "/{id}")
    public OrderResponse getOrderById(@PathVariable int id) {
        log.info("Run get order by id = {}", id);
        return orderService.getOrder(id);
    }


    @Operation(summary = "Service for adding new order")
    @PostMapping
    public AddOrderResponse addOrder(@RequestBody OrderRequest orderRequest) {
        log.info("Run add order");
        return new AddOrderResponse(orderService.addOrder(orderRequest));
    }

}
