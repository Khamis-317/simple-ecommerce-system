package com.khamis.product;

import java.time.LocalDate;

public class ProductFactory {
    public static Product createSimpleProduct(String productName, double productPrice, int productQuantity, Category category) {
        return new Product(productName, productPrice, productQuantity, category, Shippable.NO_SHIPPING, Expirable.NO_EXPIRY);
    }

    public static Product createShippableProduct(String productName, double productPrice, int productQuantity, Category category, double weight) {
        return new Product(productName, productPrice, productQuantity, category, new ShippableImpl(weight), Expirable.NO_EXPIRY);
    }

    public static Product createExpirableProduct(String productName, double productPrice, int productQuantity, Category category, LocalDate expiry) {
        return new Product(productName, productPrice, productQuantity, category, Shippable.NO_SHIPPING, new ExpirableImpl(expiry));
    }

    public static Product createShippableExpirableProduct(String productName, double productPrice, int productQuantity, Category category,
                                                          double weight, LocalDate expiry) {
        return new Product(productName, productPrice, productQuantity, category, new ShippableImpl(weight), new ExpirableImpl(expiry));
    }
}
