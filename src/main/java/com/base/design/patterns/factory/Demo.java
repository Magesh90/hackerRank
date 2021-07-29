package com.base.design.patterns.factory;

import java.util.HashMap;
import java.util.Map;

import static com.base.design.patterns.factory.Fulfillment.DIGITAL;

public class Demo {
    public static void main(String[] args) throws Exception {
        System.out.println("Creating products for cart as per order");
        Class factory = Class.forName("com.base.design.patterns.factory.AbstractFactory");
        Class[] classes = factory.getDeclaredClasses();
        for (Class cl : classes) {
            System.out.println(cl.getName());
        }
        //use org.reflections* to build the list of factory-map with key as factory name and
        //factory instance as value
        Map<String, AbstractFactory> factories = new HashMap<>();
        factories.put("Digital", new DigitalProductFactory());
        factories.put("Store", new StoreProductFactory());
        Fulfillment choice = DIGITAL;

        switch (choice) {
            case DIGITAL:
                Product product = new DigitalProductFactory().createProduct();
                product.getProductDescription();
                break;
            case STORE:
                Product product1 = new StoreProductFactory().createProduct();
                product1.getProductDescription();
                break;
            default:
                throw new Exception("Choice incorrect or chance of change is expected here");
        }
    }
}
