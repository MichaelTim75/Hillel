package edu.hillel.lesson32;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("first order");
        coffeeOrderBoard.add("second order");
        coffeeOrderBoard.add("third order");
        coffeeOrderBoard.add("fourth order");
        coffeeOrderBoard.add("fifth order");
        coffeeOrderBoard.add("sixth order");

        LOGGER.info("First initialized queue");

        coffeeOrderBoard.draw();
        //show method deliver without params
        LOGGER.info("Delivered order without number - {}", coffeeOrderBoard.deliver());

        LOGGER.info("Queue after deleting head element");
        coffeeOrderBoard.draw();

        LOGGER.info("Delivered order with number 3 - {}", coffeeOrderBoard.deliver(3));

        LOGGER.info("Queue after deleting element with number 3");
        coffeeOrderBoard.draw();

        try {
            coffeeOrderBoard.deliver(300);
        } catch (NoSuchOrderException e) {
            LOGGER.error("Exception on delivering order with number 300", e);
        }
    }
}
