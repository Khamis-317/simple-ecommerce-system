package com.khamis.orchestrator;

import com.khamis.Exceptions.ProductNotFoundException;
import com.khamis.checkout.CheckoutService;
import com.khamis.customer.Customer;
import com.khamis.customer.Item;
import com.khamis.inventory.InventoryManager;
import com.khamis.product.*;

import java.time.LocalDate;

public class ECommerceSystem {
    private final InventoryManager inventory = new InventoryManager();


    public void addProductToInventory(Product product){
        inventory.addProduct(product);
    }

    public void addProductToCart(Customer customer, String productName, int quantity){
        Product product = inventory.getProduct(productName);
        if (product == null){
            throw new ProductNotFoundException(productName);
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        customer.getShoppingCart().addItem(new Item(product, quantity));
    }

    public void checkout(Customer customer) {
        CheckoutService.checkout(customer, customer.getShoppingCart());
    }

    public Product createProduct(String name, double price, int quantity, Category category, Double weight, LocalDate expiry) {
        if (weight != null && expiry != null) {
            return ProductFactory.createShippableExpirableProduct(name, price, quantity, category, weight, expiry);
        }
        if (weight != null) {
            return ProductFactory.createShippableProduct(name, price, quantity, category, weight);
        }
        if (expiry != null) {
            return ProductFactory.createExpirableProduct(name, price, quantity, category, expiry);
        }
        return ProductFactory.createSimpleProduct(name, price, quantity, category);
    }
}
