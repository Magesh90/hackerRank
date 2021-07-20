package com.basic.javaEightFeatures;

import java.util.Optional;

class Person {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    String department;

    Optional<Address> getAddress(String temp) {
        return Optional.ofNullable(address);
    }

    private Address address;

    Person(Address address) {
        this.address = address;
    }

    public Person(){

    }
}

