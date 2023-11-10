package com.practice.TwoPointers;

public class Palindrome {
    

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
