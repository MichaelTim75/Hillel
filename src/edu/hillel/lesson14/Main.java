package edu.hillel.lesson14;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("first order");
        coffeeOrderBoard.add("second order");
        coffeeOrderBoard.add("third order");
        coffeeOrderBoard.add("fourth order");
        coffeeOrderBoard.add("fifth order");
        coffeeOrderBoard.add("sixth order");

        System.out.println("First initialized queue");
        coffeeOrderBoard.draw();
        //show method deliver without params
        System.out.println(coffeeOrderBoard.deliver());

        System.out.println("Queue after deleting head element");
        coffeeOrderBoard.draw();

        System.out.println(coffeeOrderBoard.deliver(3));

        System.out.println("Queue after deleting element with number 3");
        coffeeOrderBoard.draw();
    }
}
