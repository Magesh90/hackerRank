package com.base.design.patterns.factory;

import java.math.BigDecimal;

class StoreProductFactory implements AbstractFactory {
    @Override
    public Product createProduct() {
        return new StoreProduct(1, BigDecimal.TEN);
    }
}
