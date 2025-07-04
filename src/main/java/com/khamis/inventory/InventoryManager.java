package com.khamis.inventory;

import com.khamis.Exceptions.ProductAlreadyExistException;
import com.khamis.product.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private final Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        if (products.containsKey(product.getProductName())){
            throw new ProductAlreadyExistException(product.getProductName());
        }
        products.put(product.getProductName(), product);
    }

    public Product getProduct(String productName) {
        return products.get(productName);
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public void clearInventory() {
        products.clear();
    }

}
