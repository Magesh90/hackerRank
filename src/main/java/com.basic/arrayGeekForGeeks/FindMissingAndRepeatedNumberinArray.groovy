package com.basic.arrayGeekForGeeks

class FindMissingAndRepeatedNumberinArray {
    static void main(String[] args) {
        int[] input = [1, 2, 3, 5, 6, 7, 8, 9, 5]
        int expectedMissingNumber = 10
        int expectedRepeatedNumber = 4

        int[] occurenceArray = new int[input.length + 1]

        for (int i = 0; i < input.length; i++) {
            occurenceArray[input[i]]++
        }

        int repeatedNumber = 0
        for (int j = 1; j < occurenceArray.length; j++) {
            if (occurenceArray[j] > 1) {
                repeatedNumber = j
                break
            }
        }

        int missingNumber = 0
        for (int j = 1; j < occurenceArray.length; j++) {
            if (occurenceArray[j] < 1) {
                missingNumber = j
                break
            }
        }
        println("Repeated Number is=" + repeatedNumber)
        println("Missing Number is=" + missingNumber)
    }
}
