package com.basic.arrayGeekForGeeks

class ElementOccurringMoreTimeInArray {

    static void main(String[] args) {

        int[] array = [4, 2, 2, 3, 1]
        int threshold = (array.length) / 2

        //1. frequency array
        //2. hashMap of count find value>=threshold


        int[] freqArr = new int[array.length]

        for (int i = 0; i < array.length; i++) {
            freqArr[array[i]]++
        } //[0,2,1,1]

        print freqArr[freqArr.find { it >= threshold }]
    }
}
