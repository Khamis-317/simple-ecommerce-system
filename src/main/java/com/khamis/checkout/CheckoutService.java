package com.khamis.checkout;

import com.khamis.Exceptions.EmptyCartException;
import com.khamis.Exceptions.ExpiredProductException;
import com.khamis.Exceptions.InsufficientBalanceException;
import com.khamis.Exceptions.OutOfStockException;
import com.khamis.customer.Customer;
import com.khamis.customer.Item;
import com.khamis.customer.ShoppingCart;
import com.khamis.product.Product;
import com.khamis.shipping.ShippingItem;
import com.khamis.shipping.ShippingService;
import com.khamis.shipping.ShippingUtil;

import java.util.List;

public class CheckoutService {
    private static final double shippingCost= 30.0;
    public static void checkout(Customer customer, ShoppingCart cart){
      if (cart == null || cart.isEmpty()){
          throw new EmptyCartException("Cart is empty");
      }

      double totalCost = 0.0;

      for (Item item : cart.getItems()) {
          Product product =  item.getProduct();
          int quantity = item.getQuantity();

          if (product.getProductQuantity() < quantity){
              throw new OutOfStockException(product.getProductName(), product.getProductQuantity(), quantity);
          }

          if (product.getExpirable().isExpired()){
              throw new ExpiredProductException(product.getProductName(), product.getExpirable().getExpiryDate());
          }

          totalCost += product.getProductPrice() *quantity;
      }
        totalCost += shippingCost;
        if (customer.getBalance() < totalCost) {
            throw new InsufficientBalanceException(customer.getName(), totalCost, customer.getBalance());
        }

        customer.removeBalance(totalCost);

        List<ShippingItem> itemsToShip = ShippingUtil.gatherShippableItems(customer);
        ShippingService.shipItems(itemsToShip, customer.getAddress());

        for (Item item : cart.getItems()) {
            Product product = item.getProduct();
            product.setProductQuantity(product.getProductQuantity() - item.getQuantity());
        }

        printReceipt(cart, totalCost, shippingCost);

    }
    private static void printReceipt(ShoppingCart cart, double totalCost, double shippingCost){
        System.out.println("** Checkout receipt **");

        for (Item item : cart.getItems()) {
            String name = item.getQuantity() + "x " + item.getProduct().getProductName();
            double price = item.getQuantity() * item.getProduct().getProductPrice();
            System.out.println(name + " " + (int) price);
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + (int) (totalCost - shippingCost));
        System.out.println("Shipping " + (int) shippingCost);
        System.out.println("Amount " + (int) totalCost);
    }
}
