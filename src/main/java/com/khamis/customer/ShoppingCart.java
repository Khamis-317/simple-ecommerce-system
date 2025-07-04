package com.khamis.customer;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Item> items = new ArrayList<>();
    private double totalPrice = 0.0;

    public void addItem(Item item){
        items.add(item);
        totalPrice += item.getProduct().getProductPrice() * item.getQuantity();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        items.clear();
        totalPrice = 0.0;
        for (Item item : items) {
            totalPrice += item.getProduct().getProductPrice() * item.getQuantity();
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void clear(){
        items.clear();
        totalPrice = 0.0;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }
}
