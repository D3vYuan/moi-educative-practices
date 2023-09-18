package com.example.TwoPointers;

public class Palindrome {
    /**
     * Write a function that takes a string, s, as an input and
     * determines whether or not it is a palindrome.
     * 
     * Strategy
     * [1] Initialize two pointers at the beginning and end of the string.
     * [2] Check whether or not the current pair of characters is identical.
     * [3] If they are not identical, return FALSE. Otherwise, move both pointers by
     * one index toward the middle.
     * [4] Keep traversing them toward the middle until they meet.
     * [5] If we reach the middle of the string without finding a mismatch, return
     * TRUE.
     */

    public Palindrome() {

    }

    public boolean isPalindrome(String s) {

        // Replace this placeholder return statement with your code
        int length = s.length();
        if (length <= 1) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        char[] stringChar = s.toCharArray();

        while (start <= end) {
            char startChar = stringChar[start];
            char endChar = stringChar[end];

            if (startChar != endChar) {
                return false;
            }

            start += 1;
            end -= 1;
        }

        return true;
    }
}
