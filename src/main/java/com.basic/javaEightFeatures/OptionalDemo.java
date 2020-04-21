package com.basic.javaEightFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class OptionalDemo {

    private static String returnString(String name) throws Exception {
        Optional<String> optional = Optional.ofNullable(name);
        return optional
                .filter(it -> it.startsWith("m"))
                .map(String::toUpperCase)
                .orElseThrow(() -> new Exception("error occured"));
    }

    private static String defaultValue = "Default";

    private static String returnManipulatedString(String name) {
        return Optional.ofNullable(name)
                .orElseGet(() -> defaultValue); //can use supplier function to calculate the default value
    }

    private static Optional<List<String>> printNamesInListUsingConsumer(List<String> names, Consumer<String> consumer) throws Exception {
        Optional<List<String>> nullableNames = Optional.ofNullable(names);
        nullableNames
                .ifPresent(e -> {
                    System.out.println("Consuming the name list");
                    e.forEach(consumer);
                });
        // to get the list from optional list
        List namesFromOptionalList = nullableNames.orElse(new ArrayList<>());
        return nullableNames;
    }

    public static void main(String[] args) throws Exception {
        String name = "magesh";
        System.out.println(returnString(name));
        Consumer<String> nameConsumer = (nameFromList) -> {
            nameFromList = nameFromList + " consumed";
            System.out.println(nameFromList);
        };
        List<String> nameList = Arrays.asList("Ammu", "Magesh");
        printNamesInListUsingConsumer(nameList, nameConsumer);
    }
}
