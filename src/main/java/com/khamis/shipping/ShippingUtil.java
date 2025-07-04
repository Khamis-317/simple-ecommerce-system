package com.khamis.shipping;

import com.khamis.customer.Customer;
import com.khamis.customer.Item;
import com.khamis.customer.ShoppingCart;
import com.khamis.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ShippingUtil {
    public static List<ShippingItem> gatherShippableItems(Customer customer) {
        List<ShippingItem> shippingItems = new ArrayList<>();

       if (customer == null) {
            return shippingItems;
        }

        for (Item item : customer.getShoppingCart().getItems()) {
            Product product = item.getProduct();

            if (product.isShippable()) {
                String name = item.getQuantity() + "x " + product.getProductName();
                double weight = product.getShippable().getWeight();
                double totalWeight = weight * item.getQuantity();

                shippingItems.add(new ShippingItemImpl(name, totalWeight));
            }

        }
        return shippingItems;
    }
};