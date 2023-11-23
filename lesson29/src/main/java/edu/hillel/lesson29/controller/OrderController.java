package edu.hillel.lesson29.controller;

import edu.hillel.lesson29.model.AddOrderResponse;
import edu.hillel.lesson29.model.Order;
import edu.hillel.lesson29.model.OrderRequest;
import edu.hillel.lesson29.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Setter;
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
public class OrderController {

    @Setter(onMethod_ = @Autowired)
    private OrderService orderService;

    @Operation(summary = "Service for getting all orders")
    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @Operation(summary = "Service for getting order by id")
    @GetMapping(path = "/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrder(id);
    }

    @Operation(summary = "Service for adding new order")
    @PostMapping
    public AddOrderResponse addOrder(@RequestBody OrderRequest orderRequest) {
        return new AddOrderResponse(orderService.addOrder(orderRequest));
    }

}
