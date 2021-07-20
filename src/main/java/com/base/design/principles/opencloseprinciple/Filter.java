package com.base.design.principles.opencloseprinciple;

import java.util.List;
import java.util.stream.Stream;

interface Filter<T> {
    Stream<T> filter(List<T> t, Specification<T> tSpecification);
}
