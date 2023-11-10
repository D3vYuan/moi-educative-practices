package com.solution.TwoPointers;

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

    public boolean isPalindromeAnswer(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left = left + 1;
            right = right - 1;
        }
        return true;
    }
}
