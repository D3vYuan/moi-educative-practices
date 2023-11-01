package com.solution.DynamicProgramming;

public class CountPalindromeSubstring {

    /**
     * Given a string, s, return the number of palindromic substrings contained in
     * it. A substring is a contiguous sequence of characters in a string.
     * A palindrome is a phrase, word, or sequence that reads the same forward and
     * backward.
     * 
     * Strategy
     * [1] Initialize a count variable with 0.
     * [2] Because any string of length 1 is always a palindrome, start by counting
     * the number of characters in the string and adding it to count.
     * [3] Check all two letter substrings to see if they’re palindromes, and update
     * count accordingly.
     * [4] Using the results of the previous steps, increment count for any string
     * of length greater than 2 if its first and last characters match, and the rest
     * of the string is also a palindrome.
     * [5] Return the value of count, which represents the number of palindromic
     * substrings in the given string.
     */
    public CountPalindromeSubstring() {

    }

    public int countPalindromicSubstrings(String s) {
        int count = 0;

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            count += dp[i][i + 1] ? 1 : 0;
        }

        for (int length = 3; length <= s.length(); length++) {
            for (int i = 0, j = length - 1; j < s.length(); i++, j++) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                count += dp[i][j] ? 1 : 0;
            }
        }

        return count;
    }
}
