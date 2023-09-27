package com.example.DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    /**
     * Suppose you are given two strings. You need to find the length of the longest
     * common subsequence between these two strings.
     * A subsequence is a string formed by removing some characters from the
     * original string while maintaining the relative position of the remaining
     * characters. For example, “abd” is a subsequence of “abcd”, where the removed
     * character is “c”.
     * If there is no common subsequence, then return 0.
     * 
     * Strategy
     * [1] Create a table to store the computed results.
     * [2] Start iterating the characters of both strings and compare them.
     * [3] If the characters are equal, continue checking for the next characters,
     * and store the result.
     * [4] If not equal, compute the result by incrementing both pointers
     * individually, and store the maximum.
     * [5] Return the value stored in the table.
     */

    public LongestCommonSubsequence() {

    }

    private int longestCommonSubsequenceHelper(String str1, String str2, int row, int col, int[][] dp) {
        // base case
        if (row == str1.length() || col == str2.length()) {
            return 0;
        }
        // unseen node
        else if (dp[row][col] == -1) {
            // match found increase count by 1
            if (str1.charAt(row) == str2.charAt(col)) {
                dp[row][col] = 1 + longestCommonSubsequenceHelper(str1, str2, row + 1, col + 1, dp);
            }
            // continue transversing left child and right child
            else {
                dp[row][col] = Math.max(longestCommonSubsequenceHelper(str1, str2, row + 1, col, dp),
                        longestCommonSubsequenceHelper(str1, str2, row, col + 1, dp));
            }
        }

        System.out.println(String.format("Processing (%d, %d) - %s vs %s [total matched: %d]",
                row, col, str1.charAt(row), str2.charAt(col), dp[row][col]));
        return dp[row][col];
    }

    public int longestCommonSubsequence(String str1, String str2) {
        // Replace this placeholder return statement with your code

        int rows = str1.length();
        int cols = str2.length();
        int[][] memo = new int[rows][cols];

        // Set unseen state
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int longestFound = longestCommonSubsequenceHelper(str1, str2, 0, 0, memo);
        System.out.println(String.format("The longest common subsequence is %d", longestFound));
        return longestFound;
    }
}
