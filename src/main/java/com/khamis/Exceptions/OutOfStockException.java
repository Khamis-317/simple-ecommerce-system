package com.khamis.Exceptions;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String productName, int available, int needed) {
        super("No enough stock for:'" + productName + "'. Available: " + available + ", needed: " + needed);
    }
}
