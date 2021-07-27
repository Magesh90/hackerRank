package com.base.design.patterns.builder;

public class CodeBuilderr {
    protected CodeElement root = new CodeElement();

    public CodeBuilderr(String className) {
        root.fieldName = className;
        root.fieldType = "class";
    }

    public CodeBuilderr addField(String name, String type) {
        CodeElement fieldElement = new CodeElement(name, type);
        root.codeElements.add(fieldElement);
        return this;
    }


    @Override
    public String toString() {
        return root.toString();
    }
}
