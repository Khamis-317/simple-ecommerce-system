package com.khamis.product;

public class Product {
    private String productName;
    private double productPrice;
    private int productQuantity;
    private Category category;
    private Shippable shippable;
    private Expirable expirable;

    public Product(String productName, double productPrice, int productQuantity,
                   Category productCategory, Shippable shippable, Expirable expirable) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.category = productCategory;
        this.shippable = shippable;
        this.expirable = expirable;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Shippable getShippable() {
        return shippable;
    }

    public void setShippable(Shippable shippable) {
        this.shippable = shippable;
    }

    public Expirable getExpirable() {
        return expirable;
    }

    public void setExpirable(Expirable expirable) {
        this.expirable = expirable;
    }

    public Boolean isShippable() {
        return shippable != Shippable.NO_SHIPPING;
    }

    public boolean isExpirable() {
        return expirable != Expirable.NO_EXPIRY;
    }


}
