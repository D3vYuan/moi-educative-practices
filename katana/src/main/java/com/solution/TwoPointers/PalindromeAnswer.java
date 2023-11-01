package com.solution.TwoPointers;

public class PalindromeAnswer {
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
