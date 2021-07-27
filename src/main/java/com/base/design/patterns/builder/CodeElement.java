package com.base.design.patterns.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CodeElement {
    String fieldName;
    String fieldType;
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();
    List<CodeElement> codeElements = new ArrayList<>();

    public CodeElement() {
    }

    public CodeElement(String fieldName, String fieldType) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }

    private String toStringImpl(int indent) {
        StringBuilder sb = new StringBuilder();
        String i = String.join("", Collections.nCopies(indent * indentSize, " "));
        sb.append(String.format("%s%s%s %s %s", i, "public ", fieldType, fieldName, newLine));
        sb.append(String.format("%s%s", "{", newLine));

        for (CodeElement e : codeElements)
            sb.append(e.toStringImpl(indent + 1));

        sb.append(String.format("%s%s", "}", newLine));
        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }
}
