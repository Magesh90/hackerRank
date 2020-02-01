package com.basic.stringProblems

class LargestPalindrome {

    static String largestPalindrome(String input) {
        String longestPalindrome = ""
        if (input == input.reverse()) {
            longestPalindrome = input
        }

        longestPalindrome
    }


    static void main(String[] args) {
        "vivas"
        println("longest palindrome in string - vivas is " + largestPalindrome("vivas"))
    }
}
