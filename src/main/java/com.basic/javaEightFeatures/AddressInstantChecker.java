package com.basic.javaEightFeatures;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.time.Instant.now;

public class AddressInstantChecker {


    public static void main(String[] args) {

        new AddressInstantChecker().regexPatternMatcher();
        Address address = new Address(now());
        Person person = new Person(address);
        AddressInstantChecker addressInstantChecker = new AddressInstantChecker();
        System.out.println("Is instant valid - " + addressInstantChecker.isInstantValid(person));
        Map<String, List<String>> map = addressInstantChecker.groupAccrualDtosPerChargeType();
        map.forEach((chargeType, refNums) -> System.out.println("Reference Numbers matching chargeType:" + chargeType + " are " + refNums));

        try {
            Person person1 = addressInstantChecker.getPersonUsingJava8(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    void maskeingmethod(Pattern pattern, String str, int groupNumber){

    }

    String regexPatternMatcher() {


        String line = "<si>TM-djhj.dh@gmail.com*jhhjd</si>";
        String line2 = "<si>789The world is crazy TM-djhj.dh@gmail.comjhhjdTM-gha@gmail.com*</si>";

        String line1 = "2SITheTM-SRBBALAJISR@GMAIL.COM*VENDOR ZE CANT BE BOOKED AT THIS TIME,TM-NEWINDIAPOINT@GMAIL.COM*ADDEDNEWS";
        //String patternTested= "(2SI)([a-zA-Z0-9\\W.]{0,})(TM-)([a-zA-Z0-9\\W.]+@[a-zA-Z0-9\\W.]+)(\\*)([a-zA-Z0-9\\W.]{0,})(TM-)([a-zA-Z0-9\\W.]+@[a-zA-Z0-9\\W.]+)(\\*)([a-zA-Z0-9\\W.]+)";
        //String patternTested= "(2SI)([a-zA-Z0-9\\W.]{0,})(TM-)([a-zA-Z0-9\\W.]+@[a-zA-Z0-9\\W.]+)(\\*)([a-zA-Z0-9\\W.]{0,})(<\\/si>)";
        String pattern = "(<si>)([a-zA-Z0-9\\W.]{0,})(TM-)([a-zA-Z0-9\\W.]+@[a-zA-Z0-9\\W.]+)(\\*)([a-zA-Z0-9\\W.]+)(<\\/si>)";
        //String pattern = "(<si>)([0-0]{1,3})(TM-)([a-zA-Z0-9\\W.]+@[a-zA-Z0-9\\W.]+)(\\*)([a-zA-Z0-9\\W.]+)(<\\/si>)";
        //String onlyEmailPattern = "(TM-)([a-zA-Z0-9+._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)";
        // Create a Pattern object

        String patternStartingWithTm = "(<si>)(TM-)([^\\*]{0,})([a-zA-Z0-9\\W.]+)(<\\/si>)";
        String patternStartingWithoutTm = "(<si>)((?!TM-).+?)(TM-)([^\\*]{0,})([a-zA-Z0-9\\W.]+)(<\\/si>)";

        String siEmailPattern = "(2SI)([a-zA-Z0-9\\W.]{0,})(TM-)([^\\*]{0,})([a-zA-Z0-9\\W.]+)";
        Pattern r = Pattern.compile(patternStartingWithTm);
        Pattern r1 = Pattern.compile(patternStartingWithoutTm);

        // Now create matcher object.
        Matcher withTmMatcher = r.matcher(line2);
        Matcher withoutTmMatcher = r1.matcher(line2);
        if (withTmMatcher.find()) {
            System.out.println("Found value: " + withTmMatcher.group(0));
            System.out.println("Found value: " + withTmMatcher.group(1));
            System.out.println("Found value: " + withTmMatcher.group(2));
            System.out.println("Found value: " + withTmMatcher.group(3));
            System.out.println("Found value: " + withTmMatcher.group(4));
            System.out.println("Found value: " + withTmMatcher.group(5));
        } else {
            System.out.println("NO MATCH for withTmMatcher");
        }

        if(withoutTmMatcher.find()){
            System.out.println("Found value: " + withoutTmMatcher.group(0));
            System.out.println("Found value: " + withoutTmMatcher.group(1));
            System.out.println("Found value: " + withoutTmMatcher.group(2));
            System.out.println("Found value: " + withoutTmMatcher.group(3));
            System.out.println("Found value: " + withoutTmMatcher.group(4));
            System.out.println("Found value: " + withoutTmMatcher.group(5));
        } else{
            System.out.println("NO MATCH for withoutTmMatcher");
        }
        return "kumar";
    }

    boolean isInstantValid(Person person) {
        Optional<Person> optionalPerson = Optional.ofNullable(person);

        return optionalPerson
                .flatMap(person1 -> person1.getAddress("s"))
                .flatMap(Address::getInstant)
                .filter(instant -> instant.isAfter(now()))
                .isPresent();
    }

    Map<String, List<String>> groupAccrualDtosPerChargeType() {
        AccrualDto accrualDto = new AccrualDto();
        accrualDto.setChargeType("CVT");
        accrualDto.setRefNum("RefNum1");
        AccrualDto accrualDto1 = new AccrualDto();
        accrualDto1.setChargeType("INT");
        accrualDto1.setRefNum("RefNum1");

        AccrualDto accrualDto2 = new AccrualDto();
        accrualDto2.setChargeType("CVT");
        accrualDto2.setRefNum("RefNum2");
        AccrualDto accrualDto3 = new AccrualDto();
        accrualDto3.setChargeType("INT");
        accrualDto3.setRefNum("RefNum2");

        List<AccrualDto> accrualDtos = new ArrayList<>();
        accrualDtos.add(accrualDto);
        accrualDtos.add(accrualDto1);
        accrualDtos.add(accrualDto2);
        accrualDtos.add(accrualDto3);

//        Map map = accrualDtos.stream().collect(Collectors.toMap(AccrualDto::getChargeType,AccrualDto::getRefNum));
//        map.forEach((key, value) -> System.out.println(key +"="+value));
        Map<String, List<AccrualDto>> groupedMap = accrualDtos
                .stream()
                .collect(Collectors.groupingBy(AccrualDto::getChargeType));

        Map<String, List<String>> refNumsMappedWithChargeType = new HashMap<>();
        groupedMap.forEach((key, accrualDtosPerChargeType) -> {
            List<String> refNumsPerChargeType = accrualDtosPerChargeType
                    .stream()
                    .map(AccrualDto::getRefNum)
                    .collect(Collectors.toList());
            refNumsMappedWithChargeType.putIfAbsent(key, refNumsPerChargeType);

        });
        Consumer<List<AccrualDto>> consolePrinter = list -> list.forEach(
                a -> System.out.println("Printing chargeType with Consumer " + a.getChargeType()));
        consumeWithNamedConsumer(accrualDtos, consolePrinter);
        return refNumsMappedWithChargeType;
    }

    void consumeWithNamedConsumer(List<AccrualDto> accrualDtos, Consumer<List<AccrualDto>> consumer) {
        consumer.accept(accrualDtos);
    }
    //[INT:[RefNum1,RefNum2], CVT:[RefNum1,RefNum2]]

    Person getPersonUsingJava8(Supplier<Person> personSupplier) throws InterruptedException {
        if (personSupplier != null) {
            Person person = personSupplier.get();
            return person;
        } else {
            Supplier<Instant> instant = () -> now();
            Supplier<Person> personSupplier1 = () -> new Person(new Address(instant.get()));
            Person person1 = new Person(new Address(instant.get()));
            System.out.println("Printing the instances using Supplier");
            System.out.println(instant.get());
            Thread.sleep(12000);
            System.out.println(instant.get());
            return personSupplier1.get();
        }
    }
}
