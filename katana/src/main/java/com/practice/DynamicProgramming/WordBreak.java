package com.practice.DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    /*
     * 
     * Strategy
     * [1] Find all possible prefixes of the input string.
     * [2] For each prefix, check if it’s contained in the dictionary. If it is,
     * repeat the process with the rest of the string.
     * [3] For the remaining string, find all possible prefixes in the dictionary.
     * Continue this process until the whole string has been processed.
     * [4] After processing the whole string, return TRUE if it could be broken into
     * space-separated dictionary words. Otherwise, return FALSE.
     * 
     * Explanation
     * [1] Use a lookup table, dp, of size n+1, where n is the length
     * of the input string and 1 is added to cater the empty string. This table will
     * store the results of the shorter prefixes that can be used, in O(1) lookup
     * time, for solving the longer prefixes.
     * [2] The dp is initialized with FALSE except for dp[0], which is set TRUE
     * because an empty string is assumed to be a valid word in the dictionary.
     * [3] Then, using two pointers, i and j, we check every possible prefix s[j..i]
     * and whether they’re contained in the dictionary.
     * - If the substring s[j..i] is found in the dictionary, we don’t check further
     * smaller substrings.
     * - We also check whether dp[j] is TRUE, which tells us that the prefix s[0..j]
     * was found in the dictionary.
     * [4] If both conditions are fulfilled, the corresponding dp index, i.e.,
     * dp[i], is
     * set to TRUE.
     * [5] We continue this process until the whole string has been processed.
     * Finally, we return the value of dp[n], which tells us that the input string
     * could be segmented into a space-separated sequence of dictionary words.
     */

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        // Create a set of words from the list so that the lookup cost in the set
        // becomes O(1)
        Set<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n + 1];

        // Set the first element to true as it represents the empty string
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // Checking if the substring from j to i is present in the wordSet and dp[j] is
                // true
                // If a substring is found, no need to check further smaller substrings
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
