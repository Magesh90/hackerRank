package com.base.design.principles.dip;

public class Demo {

    static void dependOnLowModuleInterface(RelationShipBrowser browser) {
        browser.findAllRelationsOf("John");
    }

    public static void main(String[] args) {
        Person person = new Person("John");
        Person child = new Person("Matt");
        Person child2 = new Person("Marvel");
        Relationships relationships = new Relationships();
        relationships.addParentChildRelation(person, child);
        relationships.addParentChildRelation(person, child2);
        dependOnLowModuleInterface(relationships);
    }
}
