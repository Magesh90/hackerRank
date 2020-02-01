package com.basic.sorting

class MergeSortDemo {
    static void printArray(int[] array) {
        array.each {
            print(it + ",")
        }
    }

    static int[] mergeSort(int[] array) {

        if (array.length <= 1) {
           return array
        }

        int midPoint = array.length / 2
        int[] left = new int[midPoint]
        int[] right
        if (array.length % 2 == 0) {
            right = new int[midPoint]
        } else {
            right = new int[midPoint + 1]
        }
        for (int i = 0; i < midPoint; i++)
            left[i] = array[i]
        for (int j = 0; j < right.length; j++)
            right[j] = array[midPoint + j]
        int[] result = new int[array.length]
        left = mergeSort(left)
        right = mergeSort(right)
        result = merge(left, right)
        return result
    }

    static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length]
        int leftPointer = 0
        int rightPointer = 0
        int resultPointer = 0

        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++]
                } else {
                    result[resultPointer++] = right[rightPointer++]
                }
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++]
            } else if (resultPointer < right.length) {
                result[resultPointer++] = right[rightPointer++]
            }
        }
        return result
    }

    static void main(String[] args) {

        int[] array = [5, 4, 3, 2, 1]
        println("Unsorted array")
        printArray(array)
        array = mergeSort(array)
        println("Sorted array")
        printArray(array)
    }
}
