package edu.hillel.lesson32;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class CoffeeOrderBoard {
    Deque<Order> orders;

    static final Logger LOGGER = LogManager.getLogger();

    public CoffeeOrderBoard() {
        orders = new ArrayDeque<>();
    }

    public void add(String name) {
        int number = orders.isEmpty() ? 1 : (orders.getLast().getNumber() + 1);
        orders.addLast(new Order(name, number));
        LOGGER.info("Added new order with name = {} and id = {}", name, number);
    }

    public Order deliver() {
        return orders.pollFirst();
    }

    public Order deliver(int number) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getNumber() == number) {
                iterator.remove();
                LOGGER.info("Deliver order with id = {}", number);
                return order;
            }
        }
        throw new NoSuchOrderException("Order with number " + number + " not exists!");
    }

    public void draw() {
        LOGGER.info("Number | name");
        orders.forEach(c -> LOGGER.info("{} | {}", c.getNumber(), c.getName()));
    }
}
