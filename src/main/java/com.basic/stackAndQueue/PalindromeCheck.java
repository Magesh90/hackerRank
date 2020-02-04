package com.basic.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheck {

    public static void main(String[] args) {
        Stack<Character> characterStack = new Stack<>();
        Queue<Character> characterQueue = new LinkedList<>();
        String input = "madamm";
        for (Character c : input.toCharArray()) {
            characterStack.push(c);
            characterQueue.add(c);
        }
        while (!characterQueue.isEmpty()) {
            if (characterQueue.poll() != characterStack.pop()) {
                System.out.println(input + " string is not palindrome");
                break;
            }
        }
    }
}
