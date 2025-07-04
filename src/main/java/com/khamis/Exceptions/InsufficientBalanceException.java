package com.khamis.Exceptions;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String name, double totalCost, double balance) {
        super("Insufficient balance for '" + name + "'. Total cost: " + totalCost + ", balance: " + balance);
    }
}
