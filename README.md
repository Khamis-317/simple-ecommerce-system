# Simple E-Commerce Console App

A Java console-based app that simulates basic e-commerce operations with clear OOP structure.

## Features
- Add products (shippable, expirable)
- Add to cart & checkout
- Handle edge cases with custom exceptions
- Centralized inventory (admin-only control)

## Scenarios in `Main.java`
1. Normal checkout  
2. Insufficient balance  
3. Expired product  
4. Out of stock  
5. Empty cart  
6. Mix of shippable & non-shippable items  

## Notes
- No user interaction or multiple customers
- Admin is the only actor (adds products, manages flow)

Run `Main.java` to test all scenarios.
