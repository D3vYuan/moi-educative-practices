package com.solution.DynamicProgramming;

public class LongestPalindromicSubstring {
    /**
     * 
     * 
     * Strategy
     * [1] Create a resultant array, res, to store the starting and ending indexes
     * of the longest palindromic substring. Initialize it with [0,0] depicting that
     * the longest palindromic substring seen so far is the first character of the
     * input string. By definition, any string of length 1 is always a palindrome.
     * [2] Initialize a lookup table, dp, with FALSE.
     * [3] Base case 1: The diagonal in the lookup table is populated with TRUE,
     * because any cell in the diagonal corresponds to a substring of length 1, and
     * any string of length 1 is always a palindrome.
     * [4] Base case 2: We check whether all two-letter substrings are palindromes
     * and update the res and dp accordingly. We do this by iterating over the
     * string, comparing s[i] and s[i+1], and storing the result at dp[i][i+1].
     * After that, we also update res if the value of dp[i][i+1] is TRUE, which
     * tells us that the two-letter substring was a palindrome.
     * [5] After these base cases, we check all substrings of lengths greater than
     * 2. However, we only compare the first and the last characters. The rest of
     * the string is checked using the lookup table. For example, for a given string
     * “zing”, we want to check whether “zin” is a palindrome. We’ll only compare
     * ‘z’ and ‘n’ and check the value of dp[1][1], which will tell whether the
     * remaining string “i”, represented by s[1..1], is a palindrome. We’ll take the
     * logical AND of these two results and store it at dp[0][2] because “zin” is
     * represented by the substring s[0..2]. This way, we’ll avoid redundant
     * computations and check all possible substrings using the lookup table.
     */
    public static String longestPalindromicSubstring(String s) {
        // To store the starting and ending indexes of LPS
        int[] res = { 0, 0 };
        int n = s.length();

        // Initialize a lookup table of dimensions n * n
        boolean[][] dp = new boolean[n][n];

        // Base case: A string with one letter is always a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Base case: Substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1)); // Check if 2 charactes are equal
            if (dp[i][i + 1]) {
                res = new int[] { i, i + 1 }; // update the resultant array
            }
        }

        // Substrings of lengths greater than 2
        for (int length = 3; length <= n; length++) {
            int i = 0;
            for (int j = length - 1; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                if (dp[i][j]) {
                    res = new int[] { i, j };
                }
                i++;
            }
        }

        return s.substring(res[0], res[1] + 1); // Return the longest palindromic substring
    }
}
