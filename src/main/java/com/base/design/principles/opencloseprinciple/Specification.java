package com.base.design.principles.opencloseprinciple;

public interface Specification<T> {
    boolean isSatisfied(T t);
}

