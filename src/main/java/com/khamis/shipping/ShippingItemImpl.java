package com.khamis.shipping;

public class ShippingItemImpl implements ShippingItem{
    private String name;
    private double weight;

    public ShippingItemImpl(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
