package com.khamis.Exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String productName) {
        super("Product '" + productName + "' not found");
    }
}
