package com.base.design.patterns.factory;

import java.math.BigDecimal;

class DigitalProductFactory implements AbstractFactory {

    @Override
    public Product createProduct() {
        return new DigitalProduct(2, BigDecimal.TEN);
    }
}
