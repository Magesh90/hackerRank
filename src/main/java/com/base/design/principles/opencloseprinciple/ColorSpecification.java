package com.base.design.principles.opencloseprinciple;

class ColorSpecification implements Specification<Product> {

    public ColorSpecification(String color) {
        this.color = color;
    }

    private String color;

    @Override
    public boolean isSatisfied(Product product) {
        return product.color.equalsIgnoreCase(color);
    }
}
