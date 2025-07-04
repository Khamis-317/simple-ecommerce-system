package com.khamis.product;

public interface Shippable {
    double getWeight();

    Shippable NO_SHIPPING = () -> 0.0;
}
