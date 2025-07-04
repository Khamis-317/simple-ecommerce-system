package com.khamis.product;

import com.khamis.Exceptions.InvalidProductException;

import java.time.LocalDate;

public class ProductFactory {
    public static Product createSimpleProduct(String productName, double productPrice, int productQuantity, Category category) {
        validate(productName, productPrice, productQuantity);
        return new Product(productName, productPrice, productQuantity, category, Shippable.NO_SHIPPING, Expirable.NO_EXPIRY);
    }

    public static Product createShippableProduct(String productName, double productPrice, int productQuantity, Category category, double weight) {
        validate(productName, productPrice, productQuantity);
        validateWeight(weight);
        return new Product(productName, productPrice, productQuantity, category, new ShippableImpl(weight), Expirable.NO_EXPIRY);
    }

    public static Product createExpirableProduct(String productName, double productPrice, int productQuantity, Category category, LocalDate expiry) {
        validate(productName, productPrice, productQuantity);
        return new Product(productName, productPrice, productQuantity, category, Shippable.NO_SHIPPING, new ExpirableImpl(expiry));
    }

    public static Product createShippableExpirableProduct(String productName, double productPrice, int productQuantity, Category category,
                                                          double weight, LocalDate expiry) {
        validate(productName, productPrice, productQuantity);
        validateWeight(weight);
        return new Product(productName, productPrice, productQuantity, category, new ShippableImpl(weight), new ExpirableImpl(expiry));
    }

    private static void validate(String name, double price, int quantity) {
        if (name == null || name.isBlank()) {
            throw new InvalidProductException("name", "Product name cannot be empty.");
        }
        if (price <= 0) {
            throw new InvalidProductException("price", "Price must be greater than 0");
        }
        if (quantity < 0) {
            throw new InvalidProductException("quantity", "Quantity cannot be negative");
        }
    }
    private static void validateWeight(double weight) {
        if (weight <= 0) {
            throw new InvalidProductException("weight", "Weight must be greater than 0 for shippable products.");
        }
    }

}
