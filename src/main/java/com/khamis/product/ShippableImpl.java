package com.khamis.product;

public class ShippableImpl implements Shippable{
    private final double weight;

    public ShippableImpl(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
