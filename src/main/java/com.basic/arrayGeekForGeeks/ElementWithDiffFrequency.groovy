package com.basic.arrayGeekForGeeks

class ElementWithDiffFrequency {

    public static void main(String[] args) {

        int[] inputArray = [1, 1, 2, 2, 3]

        int[] freqArr = new int[inputArray.length]

        for (int i = 0; i < inputArray.length; i++) {
            freqArr[inputArray[i]]++
        }

        freqArr.eachWithIndex {item, index ->
            if (item % 2 != 0)
                print index
        }
    }
}
