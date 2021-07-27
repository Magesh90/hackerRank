package com.base.design.principles.opencloseprinciple;

import org.javatuples.Triplet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OpenCloseDpDemo {
    public static void main(String[] args) {
        Product p1 = new Product("Green", "M", "T-Shirt", BigDecimal.TEN);
        Product p2 = new Product("Blue", "M", "T-Shirt", BigDecimal.TEN);
        Product p3 = new Product("Red", "M", "T-Shirt", BigDecimal.TEN);
        Product p4 = new Product("Red", "S", "T-Shirt", BigDecimal.TEN);
        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        Specification colorSpec = new ColorSpecification("Green");
        Specification sizeSpec = new SizeSpecification("M");
        ProductFilter filter = new ProductFilter();
        filter.filter(products, colorSpec).forEach(p -> System.out.println(((Product) p).getColor()));
        filter.filter(products, sizeSpec).forEach(p -> System.out.println(((Product) p).getSize()));
        filter.filter(products, sizeSpec).filter(p -> colorSpec.isSatisfied(p))
                .forEach(p -> System.out.println(((Product) p).getColor()));
        Specification<Product> colorOrSizeSpec = new ColorOrSizeSpec(colorSpec, sizeSpec);
        filter.filter(products, colorOrSizeSpec).forEach(p -> System.out.println(p.getColor()));
    }
}

