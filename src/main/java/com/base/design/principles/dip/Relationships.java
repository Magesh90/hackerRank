package com.base.design.principles.dip;

import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;

public class Relationships implements RelationShipBrowser {
    List<Triplet<Person, Relationship, Person>> relationships = new ArrayList<>();

    void addParentChildRelation(Person p1, Person p2) {
        relationships.add(new Triplet<>(p1, Relationship.PARENT, p2));
        relationships.add(new Triplet<>(p2, Relationship.CHILD, p1));

    }

    @Override
    public void findAllRelationsOf(String name) {
        relationships.stream()
                .filter(o -> o.getValue1() == Relationship.PARENT
                        && o.getValue0().getName().equalsIgnoreCase(name))
                .forEach(o -> System.out.println(name + " has got Parent relations with " + o.getValue2().getName()));
    }
}
