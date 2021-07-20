package com.basic.javaEightFeatures;

import com.basic.linkedListGeekForGeeks.LinkedList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private static Optional<List<String>> receiveOptionalListWithConsumer(Optional<List<String>> optionalStringList,
                                                                          Consumer<List> stringConsumer) {


        Optional<List<String>> optmappedStrings = optionalStringList.map((List<String> name) -> {
            List<String> ret = name.stream().map(s -> "hello " + s).collect(Collectors.toList());
            return Optional.of(ret);
        }).orElse(Optional.empty());

        List<String> mappedStrings = optionalStringList.map((List<String> name) -> {
            List<String> ret = name.stream().map(s -> "hello " + s).collect(Collectors.toList());
            return ret;
        }).orElse(new ArrayList<>());
        return Optional.of(mappedStrings);
        /*return optionalStringList.flatMap(list -> {
            stringConsumer.accept(list);
            return Optional.of(list);
        });*/
        /*optionalStringList
                .ifPresent(strings -> {
                    stringConsumer.accept(strings);
                });

        return Optional.of(new ArrayList<String>());*/
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
        findMaxElementInArray(new int[]{4, 7, 9, 10, 23, 56, 23, 10});
        checkConcurrentModification();
        areTwins("abcdefgh", "abcdehgf");
        findDegreeOfSmallestSubArray(new int[]{1, 2, 3, 4, 2, 2, 3});
        allSubArraysOfArray(new int[]{1, 2, 3, 4});
        charactersNeededInFrontToMakeItPallindrome();
        duplicatesInArrayWithoutAdditionalObj(new int[]{2, 3, 8, 2, 5});
        organizeUserActivity();
        reverseArray(new int[]{3, 5, 7, 8, 2});
        secondHighest(new int[]{3, 5, 7, 3, 2});
        findMissingNumberInArray(new int[]{2, 3, 4, 5});
        findSumInSortedArray(15, new int[]{3, 6, 9, 15});
        findSum(8, new int[]{3, 2, 6, 5});
        characterManipulationCalculator("tea", "toe");
        uniquenessInAString("mageshh");
        int[] numbers = {1, 3, 4, 6, 7, 9, 10, 35, 56};
        int[] numbersDup = {1, 3, 4};
        Integer[] container = new Integer[numbers.length];
        int pointerForContainer = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (!binarySearch(numbers[i], numbersDup)) {
                container[pointerForContainer] = numbers[i];
                pointerForContainer++;
            }
        }
        System.out.println(binarySearch(10, numbers));
        Consumer<String> nameConsumer = (nameFromList) -> {
            nameFromList = nameFromList + " consumed";
            System.out.println(nameFromList);
        };
        Consumer<List> listConsumer = (List list) -> {
            list.forEach(nameInList -> {
                System.out.println(nameInList);
            });
        };
        List<Integer> lj = (List<Integer>) Arrays.asList(container);
        listConsumer.accept(lj);
        String name = "magesh";
        System.out.println(returnString(name));
        List<String> nameList = Arrays.asList("Ammu", "Magesh");
        List<String> parents = Arrays.asList("Malathi");
        ArrayList<String> par = new ArrayList<>(parents);
        par.addAll(nameList);
        listConsumer.accept(par);
        Optional<List<String>> optionalReturn = receiveOptionalListWithConsumer(Optional.of(nameList), listConsumer);

        optionalReturn.ifPresent(listOptional -> {
            listOptional.forEach(nameConsumer);
        });

        printNamesInListUsingConsumer(nameList, nameConsumer);
    }

    void sortAlistUsingConsumer(List<Integer> numbers, Consumer<List<Integer>> sortingAlgo) {

        //numbers.stream().collect(Collectors.toMap());
    }

    static boolean binarySearch(int num, int[] array) {
        //1 2 3 4 5 6 8 9
        int left = 0;
        int right = array.length - 1;
        int middle = 0;
        boolean found = false;
        while (left <= right) {
            middle = (left + right) / 2;
            if (array[middle] > num) {
                right = middle - 1;
            } else if (array[middle] < num) {
                left = middle + 1;
            } else {
                found = true;
                break;
            }
        }
        return found;
    }

    static boolean uniquenessInAString(String str) {
        char[] charactersInString = str.toCharArray();
        int[] frequencyArray = new int[256];
        boolean unique = true;
        for (int i = 0; i < charactersInString.length; i++) {
            frequencyArray[charactersInString[i]]++;
            if (frequencyArray[charactersInString[i]] > 1) {
                System.out.println("Uniquenesss broke because of character " + charactersInString[i]);
                unique = false;
                return unique;
            }
        }
        return unique;
    }

    static int[] characterManipulationCalculator(String word, String word2) {
        // tea toe
        int[] manipulator = new int[2];
        if (word.length() != word2.length())
            return new int[]{-1, -1};
        else {
            char[] tempArrayForWord1 = word.toCharArray();
            Arrays.sort(tempArrayForWord1);
            char[] tempArrayForWord2 = word2.toCharArray();
            Arrays.sort(tempArrayForWord2);
            String sorterdWord2 = new String(tempArrayForWord2);
            String sorterdWord1 = new String(tempArrayForWord1);
            int word1manipulatorCounter = 0;
            int word2manipulatorCounter = 0;
            for (int i = 0; i < sorterdWord1.length(); i++) {
                if (!binarySearch(sorterdWord1.charAt(i), sorterdWord2)) {
                    word1manipulatorCounter++;
                }
            }

            for (int i = 0; i < sorterdWord2.length(); i++) {
                if (!binarySearch(sorterdWord2.charAt(i), sorterdWord1)) {
                    word2manipulatorCounter++;
                }
            }

            manipulator[0] = word1manipulatorCounter;
            manipulator[1] = word2manipulatorCounter;
        }
        return manipulator;
    }

    static boolean binarySearch(char character, String word) {
        boolean found = false;
        int left = 0;
        int right = word.length();
        int middle = 0;
        while (left <= right) {
            middle = (left + right) / 2;
            if (word.charAt(middle) > character) {
                right = middle - 1;
            } else if (word.charAt(middle) < character) {
                left = middle + 1;
            } else {
                found = true;
                break;
            }
        }
        return found;
    }

    static boolean searchInUnSortedArray(int number, int[] array) {
        //[2,4,1,5] 1 - 2-1 1 4-1 3 1-1 0
        boolean found = false;
        Set<Integer> complement = new HashSet<>();
        for (int i = 0; i < array.length; i++) {

        }
        return found;
    }

    static boolean findSum(int expectedSum, int[] array) {
        //[2,5,2,2] 7
        boolean found = false;
        Set<Integer> differenceContainer = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            int difference = expectedSum - array[i];
            if (differenceContainer.contains(array[i])) {
                found = true;
                break;
            } else
                differenceContainer.add(difference);
        }
        return found;
    }

    static boolean findSumInSortedArray(int expectedSum, int[] array) {
        boolean found = false;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum > expectedSum) {
                right--;
            } else if (sum < expectedSum) {
                left++;
            } else
                return true;
        }
        return found;
    }

    static int findMissingNumberInArray(int[] numbers) {
        //[2,4,3,5] 1
        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i])
                max = numbers[i];
        }
        int n = numbers.length + 1;
        int sum = (n * (n + 1)) / 2;
        int[] indexArray = new int[++max];
        for (int i = 0; i < numbers.length; i++) {
            indexArray[numbers[i]]++;
            sum -= numbers[i];
        }//[0,0,1,1,1,1]
        System.out.println("Missing number is" + sum);
        for (int i = 1; i < indexArray.length; i++) {
            if (indexArray[i] == 0)
                return i;
        }
        return 0;
    }

    static int secondHighest(int[] numbers) {
        //[3,5,7,3,2] 5
        int highest = 0;
        int secondHighest = 0;
        /*for (int i = 0; i < numbers.length; i++) {
            if (highest < numbers[i])
                highest = numbers[i];
        }*/
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > highest) {
                secondHighest = highest;
                highest = numbers[i];
            }
            if (numbers[i] > secondHighest && numbers[i] < highest) {
                secondHighest = numbers[i];
            }
        }
        System.out.println("second highest is " + secondHighest);
        return secondHighest;
    }

    static int[] reverseArray(int[] array) {
        //0 1 2 3
        //3-3 3-2 3-1 3-0
        //0 1 2 3
        //2,3,4,5,6
        //6,5,4,3,2
        //tem=[0] [0]=[l-0] [l-0]=[0]
        int[] reverseArray = new int[array.length];
        int length = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            reverseArray[length - i] = array[i];
        }
        int j = 0;
        int mid = reverseArray.length / 2;

        while (j <= mid - 1) {
            int temp = reverseArray[j];
            reverseArray[j] = reverseArray[length];
            reverseArray[length] = temp;
            j++;
            length--;
        }
        return reverseArray;
    }

    static Integer[] duplicatesInArray(int[] numbers) {
        Set duplicateContainer = new HashSet<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (!duplicateContainer.contains(numbers[i]))
                duplicateContainer.add(numbers[i]);
        }
        return (Integer[]) duplicateContainer.toArray();
    }

    static HashMap<String, HashMap<String, Integer>> organizeUserActivity() {
        try {
            File userLog = new File("testFIle.txt");
            FileReader fileReader = new FileReader(userLog);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileInputStream fileInputStream = new FileInputStream(userLog);
            int i;
            String line;
            if ((line = bufferedReader.readLine()) != null) {
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {

        }
        return new HashMap<String, HashMap<String, Integer>>();
    }

    static int[] duplicatesInArrayWithAdditionalObj(int[] numbers) {
        int[] duplicateNumbers = new int[256];
        //[2,4,5,3,2]
        int ptr = 0;
        boolean[] duplicate = new boolean[256];
        for (int i = 0; i < numbers.length; i++) {
            if (duplicate[numbers[i]] == true) {
                System.out.println(numbers[i] + "is duplicate");
                duplicateNumbers[ptr] = numbers[i];
                ptr++;
            } else {
                duplicate[numbers[i]] = true;
            }
        }
        return duplicateNumbers;
    }

    static boolean duplicatesInArrayWithoutAdditionalObj(int[] numbers) {
        //[2,2,5,3,4] {2, 3, 8, 8, 9} o(n^2) 1 2 3 3 7
        Arrays.sort(numbers);
        boolean found = false;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                found = true;
                break;
            }
        }
        int index = 0;
        int left = 0;
        int right = numbers.length - 1;
        boolean resetSearch = false;
        while (left < right) {
            if (numbers[left] == numbers[right]) {
                found = true;
                break;
            } else if (left == right - 1) {
                if (numbers[left] == numbers[right]) {
                    found = true;
                    break;
                }
                resetSearch = true;
            } else {
                right--;
            }
            if (resetSearch) {
                left++;
                right = numbers.length - 1;
                resetSearch = false;
            }
        }

        return found;
    }

    static boolean isPalindrome(String str) {
        boolean palindrome = true;
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {//AACECAAAA ABBA
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return palindrome;

    }

    static Character[] charactersNeededInFrontToMakeItPallindrome() {
        String beforePalindrome = "BBAAA";
        List<Character> requiredCharacters = new ArrayList<>();
        int cnt = 0;
        while (beforePalindrome.length() > 0) {
            if (isPalindrome(beforePalindrome)) {
                break;
            } else {
                requiredCharacters.add(beforePalindrome.charAt(beforePalindrome.length() - 1));
                beforePalindrome = beforePalindrome.substring(0, beforePalindrome.length() - 1);
                cnt++;
            }
        }

        char[] charArray = beforePalindrome.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right)

        {
            if (charArray[left] != charArray[right]) {
                requiredCharacters.add(charArray[right]);
            }
            left++;
            right--;
        }
        return (Character[]) requiredCharacters.toArray();
    }

    static int findDegreeOfSmallestSubArray(int[] array) {
        int degreeOfArray = findDegreeOfArray(array);
        int degreeOfSmallestArray = 0;
        List<int[]> allSubArrays = (List<int[]>) allSubArraysOfArray(array);
        for (int i = 0; i < allSubArrays.size(); i++) {
            int degreeOfCurrArray = findDegreeOfArray(allSubArrays.get(i));
            if (degreeOfCurrArray > degreeOfSmallestArray) {
                degreeOfSmallestArray = degreeOfCurrArray;
            }
        }
        return degreeOfSmallestArray;
    }

    private static int findDegreeOfArray(int[] array) {
        HashMap<Integer, Integer> degreeOfArray = new HashMap<>();
        int degree = 0;
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                if (degreeOfArray.containsKey(array[i])) {
                    degreeOfArray.put(array[i], degreeOfArray.get(array[i]) + 1);
                } else {
                    degreeOfArray.put(array[i], 1);
                }
            }
            for (int i = 0; i < degreeOfArray.size(); i++) {
                if (degreeOfArray.get(array[i]) > degree) {
                    degree = degreeOfArray.get(array[i]);
                }
            }
        }
        return degree;
    }

    static List<int[]> allSubArraysOfArray(int[] array) {
        int subArraysSum = 0;
        List<int[]> allSubArrays = new ArrayList<>();
        //1,2,3,4 1,2 1,3,1,4
        List<int[]> addArray = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            addArray.add(new int[]{array[i]});
            subArraysSum += array[i];
            List<Integer> betweenIndexs = new ArrayList<>();
            for (int j = i + 1; j < array.length; ) {
                addArray.add(new int[]{array[i], array[j]});
                subArraysSum += array[i];
                subArraysSum += array[j];
                if (++j < array.length) {
                    betweenIndexs.add(j);
                }
            }//betweenInts 2,3
            if (betweenIndexs.size() > 0) {
                for (Integer index : betweenIndexs) {
                    int[] arrayFromInner = Arrays.copyOfRange(array, i, ++index);
                    addArray.add(arrayFromInner);
                    subArraysSum += sumOfArray(arrayFromInner);
                }
            }

        }
        addArray.add(new int[]{array[array.length - 1]});
        subArraysSum += array[array.length - 1];

        return addArray;
    }

    static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static boolean areTwins(String str1, String str2) {
        boolean isTwin = false;
        if (str1.length() != str2.length()) {
            return isTwin;
        } else {
            char[] evenSwapedStr1 = str1.toCharArray();//[abcdeft] [cbadeft] [cbadtfe]
            for (int i = 0; (i + 2) < str1.length(); i = i + 4) {
                char[] temArr = str1.toCharArray();
                char temp = temArr[i];
                temArr[i] = temArr[i + 2];
                evenSwapedStr1[i] = evenSwapedStr1[i + 2];
                temArr[i + 2] = temp;
                evenSwapedStr1[i + 2] = temp;
                if (String.valueOf(temArr).equalsIgnoreCase(str2)) {
                    isTwin = true;
                    break;
                } else if (String.valueOf(evenSwapedStr1).equalsIgnoreCase(str2)) {
                    isTwin = true;
                    break;
                }
            }
            char[] oddSwapedStr1 = str1.toCharArray();//[abcdeft] [cbadeft] [cbadtfe]

            for (int i = 1; (i + 2) < str1.length(); i = i + 4) {
                char[] temArr = str1.toCharArray();
                char temp = temArr[i];
                temArr[i] = temArr[i + 2];
                oddSwapedStr1[i] = oddSwapedStr1[i + 2];
                temArr[i + 2] = temp;
                oddSwapedStr1[i + 2] = temp;
                if (String.valueOf(temArr).equalsIgnoreCase(str2)) {
                    isTwin = true;
                    break;
                } else if (String.valueOf(oddSwapedStr1).equalsIgnoreCase(str2)) {
                    isTwin = true;
                    break;
                }
            }
        }
        return isTwin;
    }

    static void checkConcurrentModification() {
        List<String> list = new ArrayList<>();
        list.add("SaiRam");
        list.add("Baba");
        list.add("Sai");
        List<String> subList = list.subList(0, 2);
        subList.set(1, "Saibaba");
        subList.equals(list);
        subList.add("Baba");
    }

    static void findMaxElementInArray(int[] array) {
        //array [4, 7 , 9 , 10, 23, 56, 23, 10]
        int left = 0;
        int right = array.length - 1;
        int middle;
        int maxNumber=0;
        while (left < right) {
            middle = (left + right) / 2;
            if (array[middle] < array[middle + 1]) {
                left = middle + 1;
            } else {
                maxNumber = array[middle];
                break;
            }
        }
        boolean didItWork = (maxNumber == 56);
    }
}
