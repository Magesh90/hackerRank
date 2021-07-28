package com.base.design.patterns.factory;

import java.math.BigDecimal;

public abstract class Product {
    abstract Product getProduct();

    int quantity;
    private BigDecimal price;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product() {
        System.out.println("Base Product");
    }

    public Product(int quantity, BigDecimal _price) {
        this.quantity = quantity;
        System.out.println("Invoked base product constructor with quantity " + quantity + " price " + _price);
    }
}

class StoreProduct extends Product {

    Fulfillment fulfillmentType;

    public StoreProduct(int _quantity, BigDecimal _price) {
        quantity = _quantity;
        setPrice(_price);
        fulfillmentType = Fulfillment.STORE;
    }

    @Override
    Product getProduct() {
        return this;
    }
}

class DigitalProduct extends Product {

    Fulfillment fulfillmentType;

    public DigitalProduct(int _quantity, BigDecimal _price) {
        quantity = _quantity;
        setPrice(_price);
        fulfillmentType = Fulfillment.DIGITAL;
    }

    @Override
    Product getProduct() {
        return this;
    }
}

enum Fulfillment {
    DIGITAL,
    STORE
}