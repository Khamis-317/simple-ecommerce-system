package com.khamis.customer;

import com.khamis.product.Product;

public class Item {
    private final Product product;
    private final int quantity;

    public Item(Product product, int quantity) {
        if (product == null) throw new IllegalArgumentException("Product cannot be null.");//temporary
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be > 0.");//temporary
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

}
