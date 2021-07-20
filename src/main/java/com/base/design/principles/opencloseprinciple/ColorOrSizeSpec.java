package com.base.design.principles.opencloseprinciple;

public class ColorOrSizeSpec implements Specification<Product> {
    Specification<Product> colorSpec;
    Specification<Product> sizeSpec;

    public ColorOrSizeSpec(Specification<Product> colorSpec, Specification<Product> sizeSpec) {
        this.colorSpec = colorSpec;
        this.sizeSpec = sizeSpec;
    }

    @Override
    public boolean isSatisfied(Product product) {
        return colorSpec.isSatisfied(product) || sizeSpec.isSatisfied(product);
    }
}
