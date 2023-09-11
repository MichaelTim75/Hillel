package edu.hillel.lesson12.phonebook;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add(new Item("Mykhailo","123456"));
        phoneBook.add(new Item("Mykhailo","123456"));//Add two equal items - I want to show that in phone book will be only one
        phoneBook.add(new Item("Mykhailo","654321"));
        phoneBook.add(new Item("Petr","121212"));
        phoneBook.add(new Item("Olena","998877"));
        phoneBook.add(new Item("Olena","887766"));
        phoneBook.add(new Item("Olena","112233"));
        phoneBook.add(new Item("Vira","334455"));

        for (Item item : phoneBook.getItems()) {
            System.out.println("Name "+item.getName()+", phone number="+item.getPhoneNumber());
        }

        //findAll
        List<Item> foundedItems = phoneBook.findAll("Vira");
        if (foundedItems!=null) {
            System.out.println("Founded:");
            for (Item item : foundedItems) {
                System.out.println("Name " + item.getName() + ", phone number=" + item.getPhoneNumber());
            }
        }
        else{
            System.out.println("Didn't find anything");
        }

        List<Item> foundedItems2 = phoneBook.findAll("Somebody");
        if (foundedItems2!=null) {
            System.out.println("Founded:");
            for (Item item : foundedItems2) {
                System.out.println("Name " + item.getName() + ", phone number=" + item.getPhoneNumber());
            }
        }
        else{
            System.out.println("Didn't find anything");
        }

        //find
        Item item = phoneBook.find("Mykhailo");
        if (item==null){
            System.out.println("Didn't find anything");
        }
        else{
            System.out.println("Found name "+item.getName()+", phone number="+item.getPhoneNumber());
        }
    }
}
