package com.basic.arrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GitModulesSorter {

    public static void main(String[] args) {
        List<String> modules = new ArrayList<String>();
        modules.add("module1");
        modules.add("module10");
        modules.add("module2");
        modules.add("module4");
        modules.add("module6");

        System.out.println("Modules In Project");
        modules.forEach(System.out::println);
        System.out.println("----------------------");

        List<String> sortedModules = new ArrayList<String>();
        sortedModules.add("module1");
        sortedModules.add("module2");
        sortedModules.add("module4");
        sortedModules.add("module6");
        sortedModules.add("module10");


        System.out.println("Modules Sorted by Git");
        sortedModules.forEach(System.out::println);
        System.out.println("----------------------");

        String[] reSortedModules = new String[sortedModules.size()];

        Iterator iterator = sortedModules.listIterator();
        while (iterator.hasNext()) {
            String moduleToBeAdded = iterator.next().toString();
            int indexOfModuleBeforeSorting = modules.indexOf(moduleToBeAdded);
            reSortedModules[indexOfModuleBeforeSorting] = moduleToBeAdded;
        }

        System.out.println("Modules resorted based on project");
        for (String module : reSortedModules) {
            System.out.println(module);
        }
        System.out.println("----------------------");
    }
}
