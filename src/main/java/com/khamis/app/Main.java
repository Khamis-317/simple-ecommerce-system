package com.khamis.app;

import com.khamis.customer.Customer;
import com.khamis.orchestrator.ECommerceSystem;
import com.khamis.product.Category;
import com.khamis.product.Product;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ECommerceSystem system = new ECommerceSystem();
        //1- Normal Scenario
        try {
            System.out.println("----- Scenario 1: Normal Checkout -----");
            Customer khamis = new Customer("Khamis", 1000, "Maadi");
            Product cheese = system.createProduct("Cheese", 100, 10, Category.GROCERIES, 0.4, LocalDate.now().plusDays(5));
            Product tv = system.createProduct("TV", 500, 5, Category.ELECTRONICS, 3.5, null);

            system.addProductToInventory(cheese);
            system.addProductToInventory(tv);

            system.addProductToCart(khamis, "Cheese", 2);
            system.addProductToCart(khamis, "TV", 1);
            system.checkout(khamis);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
        //2- Insufficient Balance
        try {
            System.out.println("\n----- Scenario 2: Insufficient Balance -----");
            Customer sara = new Customer("Sara", 100, "Giza");
            Product laptop = system.createProduct("Laptop", 800, 3, Category.ELECTRONICS, 2.0, null);
            system.addProductToInventory(laptop);

            system.addProductToCart(sara, "Laptop", 1);
            system.checkout(sara);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }

        //3- Expired Product
        try {
            System.out.println("\n----- Scenario 3: Expired Product -----");
            Customer ali = new Customer("Farida", 1000, "October");
            Product milk = system.createProduct("Milk", 50, 5, Category.GROCERIES, 0.5, LocalDate.now().minusDays(10));
            system.addProductToInventory(milk);

            system.addProductToCart(ali, "Milk", 2);
            system.checkout(ali);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }

        //4- Out of Stock
        try {
            System.out.println("\n----- Scenario 4: Out of Stock -----");
            Customer hassan = new Customer("Hassan", 1000, "New Cairo");
            Product phone = system.createProduct("Phone", 700, 1, Category.ELECTRONICS, 0.3, null);
            system.addProductToInventory(phone);

            system.addProductToCart(hassan, "Phone", 3);
            system.checkout(hassan);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }

        //5- checkout with empty cart
        try {
            System.out.println("\n----- Scenario 5: Empty Cart -----");
            Customer omar = new Customer("Omar", 500, "Badr City");

            system.checkout(omar);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }

        //6- S Shippable and Non-Shippable
        try {
            System.out.println("\n----- Scenario 6: Shippable and Non-Shippable Products -----");
            Customer mariam = new Customer("Mariam", 2000, "Maadi");

            Product microwave = system.createProduct("MicroWave", 1200, 2, Category.ELECTRONICS, 5.0, null);
            Product giftCard = system.createProduct("Gift Card", 100, 10, Category.GIFT_CARDS, null, null);

            system.addProductToInventory(microwave);
            system.addProductToInventory(giftCard);

            system.addProductToCart(mariam, "MicroWave", 1);
            system.addProductToCart(mariam, "Gift Card", 2);

            system.checkout(mariam);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }





};