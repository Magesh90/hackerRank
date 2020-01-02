package com.basic.arrayGeekForGeeks

class SortArrayBasedOnBooleanArray {

    public static void main(String[] args) {
        int[] A = [1, 9, 5, 3, 4, 6]
        boolean[] B = [false, false, true, false, false]

        int j
        for (int i = 0; i < A.length - 1; i++) {
            if (B[i]) {
                int temp = A[i]
                A[i] = A[i + 1]
                A[i + 1] = temp
            }
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (B[i]) {
                j = i
                while (B[j]) {
                    j++
                }
                // Sort array A from i to j
                Arrays.sort(A, i, j + 1)
            }
        }

        A.each {
            println(it)
        }
    }
}
