package com.khamis.customer;

import com.khamis.Exceptions.ExpiredProductException;
import com.khamis.Exceptions.InsufficientBalanceException;
import com.khamis.Exceptions.OutOfStockException;
import com.khamis.product.Product;

public class Customer {
    private String name;
    private double balance;
    private ShoppingCart shoppingCart;

    public Customer(String name, double balance) {
        if (balance < 0) throw new IllegalArgumentException("Balance must be >= 0");
        this.name = name;
        this.balance = balance;
        this.shoppingCart = new ShoppingCart();
    }


    public void removeBalance(double amount){
        if (amount > balance) throw new InsufficientBalanceException("Insufficient balance.");
        balance -= amount;
    }

    public void addToCart(Product product, int quantity){
        if (product.getProductQuantity() < quantity){
            throw new OutOfStockException(product.getProductName(), product.getProductQuantity(), quantity);
        }

        if (product.isExpirable()){
            throw new ExpiredProductException(product.getProductName(), product.getExpirable().getExpiryDate());
        }
        shoppingCart.addItem(new Item(product, quantity));
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
