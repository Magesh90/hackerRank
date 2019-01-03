package com.basic

class FrescoPlayRange {

    public static void main(String[] args) {
        int fine = 0
        String actualDateAsString = System.in.newReader().readLine()
        String expectedDateAsString = System.in.newReader().readLine()
        int[] actualDateParams = actualDateAsString.split(" ").collect {
            Integer.parseInt(it)
        }
        int[] expectedDateParams = expectedDateAsString.split(" ").collect {
            Integer.parseInt(it)
        }
        if (actualDateParams[2] - expectedDateParams[2] > 0) {
            fine = 10000
        } else {
            int monthDiff = actualDateParams[1] - expectedDateParams[1]
            if (monthDiff > 0) {
                fine = monthDiff * 500
            } else {
                int dayDiff = actualDateParams[0] - expectedDateParams[0]
                if (dayDiff > 0) {
                    fine = dayDiff * 15
                }
            }
        }
        println(fine)
    }
}
