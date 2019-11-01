package com.basic.arrayGeekForGeeks

class FillArrayBasedOnFrequency {

    public static void main(String[] args) {

        int[] arr = [5, 2, 3, 4, 5, 5, 4, 5, 6, 7]

        // [0,0,1,1,2,4,1,1]
        int[] freqArr = new int[arr.length]

        for (int i = 0; i < arr.length; i++) {
            freqArr[arr[i]]++
        }

        freqArr.each { print(it) }
    }
}
