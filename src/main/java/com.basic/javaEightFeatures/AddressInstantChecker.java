package com.basic.javaEightFeatures;

import java.util.Optional;

import static java.time.Instant.now;

public class AddressInstantChecker {


    public static void main(String[] args) {
        Address address = new Address(now());
        Person person = new Person(address);
        AddressInstantChecker addressInstantChecker = new AddressInstantChecker();
        System.out.println("Is instant valid - " + addressInstantChecker.isInstantValid(person));
    }

    boolean isInstantValid(Person person) {
        Optional<Person> optionalPerson = Optional.ofNullable(person);

        return optionalPerson
                .flatMap(person1 -> person1.getAddress("s"))
                .flatMap(Address::getInstant)
                .filter(instant -> instant.isAfter(now()))
                .isPresent();
    }
}
