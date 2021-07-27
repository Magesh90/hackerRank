package com.base.design.patterns.builder;

public class Demo {
    public static void main(String[] args) {
        CodeBuilderr codeBuilder = new CodeBuilderr("Person");
        codeBuilder.addField("name", "String")
                .addField("age", "int");
        System.out.println(codeBuilder);
    }
}
