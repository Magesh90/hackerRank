package com.basic.javaEightFeatures;

import java.util.Optional;

class Person {

    Optional<Address> getAddress(String temp) {
        return Optional.ofNullable(address);
    }

    private Address address;

    Person(Address address) {
        this.address = address;
    }
}

