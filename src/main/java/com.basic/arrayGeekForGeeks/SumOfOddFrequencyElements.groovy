package com.basic.arrayGeekForGeeks

class SumOfOddFrequencyElements {

    static void main(String[] args) {
        int[] input = [1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4]
        int[] freqArr = new int[input.length]

        for (int i = 0; i < input.length; i++) {
            freqArr[input[i]]++
        }

        assert freqArr == [0, 2, 2, 3, 5, 0, 0, 0, 0, 0, 0, 0] as int[]

        int sumOfOddFrequentElements = 0

        freqArr.eachWithIndex { int entry, int index ->
            if (entry % 2 != 0) {
                sumOfOddFrequentElements += (index * entry)
            }
        }
        print("\n" + sumOfOddFrequentElements)
    }
}
