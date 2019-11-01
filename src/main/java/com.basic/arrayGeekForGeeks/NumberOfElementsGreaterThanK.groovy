package com.basic.arrayGeekForGeeks

class NumberOfElementsGreaterThanK {

    public static void main(String[] args) {

        int[] inputArray = [2, 3, 5, 6, 6, 9]
        int k = 5

        //1. iterate through each and put items>k in a array O(N)
        //2. binary search concept - divide the items to 2 half and repeat the search O(log n)
        println inputArray.findAll { it > k }.size()

        int left = 0
        int right = inputArray.length - 1
        int leftMostIndex = right
        int middle
        while (left <= right) {

            middle = (left + right) / 2

            if (inputArray[middle] > k) {
                right = middle - 1
                leftMostIndex = middle
            } else {
                left = middle + 1
            }
        }

        println(left)
        println(right)
        println(middle)
        println(inputArray.length - leftMostIndex)
    }
}
