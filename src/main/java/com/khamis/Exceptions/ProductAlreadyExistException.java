package com.khamis.Exceptions;

public class ProductAlreadyExistException extends RuntimeException {
    public ProductAlreadyExistException(String productName) {
        super("Product '" + productName + "' already exist");
    }
}
