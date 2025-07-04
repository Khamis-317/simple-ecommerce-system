package com.khamis.shipping;

import java.util.List;

public class ShippingService {
    public static void shipItems(List<ShippingItem> items, String address){
        if (items.isEmpty()) {
            System.out.println("No items to be shipped.");
            return;
        }
        System.out.println("** Shipment notice **");

        double totalWeight = 0.0;

        for (ShippingItem item : items) {
            System.out.println(item.getName());
            totalWeight += item.getWeight();
        }
        System.out.println("Total package weight: " + totalWeight + " kg");
        System.out.println("Shipping to: " + address);
        System.out.println();
    }

}
