package com.base.design.principles.opencloseprinciple;

public class SizeSpecification implements Specification<Product> {
    String size;

    public SizeSpecification(String size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product product) {
        return product.size.equalsIgnoreCase(size);
    }
}
