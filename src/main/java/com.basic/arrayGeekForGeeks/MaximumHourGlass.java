package com.basic.arrayGeekForGeeks;

public class MaximumHourGlass {

    public int maximumHourGlass(int[][] array) {
        /* 0 1 0 0 1
           1 4 5 3 1
           3 5 7 8 45
         */
        int maximumSum = 0;
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                int sum = array[row][column]
                        + array[row][column + 1]
                        + array[row][column + 2]
                        + array[row + 1][column + 1]
                        + array[row + 2][column]
                        + array[row + 2][column + 1]
                        + array[row + 2][column + 2];
                if (sum > maximumSum) {
                    maximumSum = sum;
                }
            }
        }
        return maximumSum;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        MaximumHourGlass maximumHourGlass = new MaximumHourGlass();
        System.out.print(maximumHourGlass.maximumHourGlass(array));
    }
}
