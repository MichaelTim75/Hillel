package edu.hillel.lesson12.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private final List<Item> items;

    public PhoneBook() {
        items = new ArrayList<>();
    }

    public void add(Item item){
        if (!items.contains(item)){
            //I don't want to add absolutely equal items - so I will add only if not exists item with same name and same phone number
            //So - name+phone number - is a primary key
            items.add(item);
        }
    }

    public List<Item> findAll(String name){
        List<Item> foundItems = new ArrayList<>();
        for (Item item : items) {
            if(item.getName().equals(name)){
                foundItems.add(item);
            }
        }
        return (foundItems.isEmpty())?null:foundItems;
        //I think that in case of we didn't find anything - it's better to return empty collection. Not a null
    }

    public Item find(String name){
        for (Item item : items) {
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }

    public List<Item> getItems() {
        return items;
    }
}
