package edu.hillel.lesson14;

import java.util.*;

public class CoffeeOrderBoard {
    Deque<Order> orders;

    public CoffeeOrderBoard() {
        orders = new ArrayDeque<>();
    }

    public void add (String name){
        int number=orders.isEmpty()?1:(orders.getLast().getNumber()+1);
        orders.addLast(new Order(name,number));
    }

    public Order deliver(){
        return orders.pollFirst();
    }

    public Order deliver(int number){
        Iterator<Order> iterator = orders.iterator();
        while(iterator.hasNext()){
            Order order = iterator.next();
            if(order.getNumber()==number){
                iterator.remove();
                return order;
            }
        }
        return null;
    }

    public void draw (){
        System.out.println("Number | name");
        for (Order order : orders) {
            System.out.println(order.getNumber() + " | " + order.getName());
        }
    }
}
