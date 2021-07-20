package com.base.design.principles.opencloseprinciple;

import java.math.BigDecimal;

public class Product {

    String color;
    String size;
    String name;
    BigDecimal price;

    public Product(String color, String size, String name, BigDecimal price) {
        this.color = color;
        this.size = size;
        this.name = name;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
