package com.solution.DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    /**
     * Given a string, s, and a dictionary of strings, wordDict, check if s can be
     * segmented into a space-separated sequence of one or more dictionary words. If
     * yes, return TRUE; else, return FALSE.
     * 
     * Strategy:
     * [1] Find all possible prefixes of the input string.
     * [2] For each prefix, check if it’s contained in the dictionary. If it is,
     * repeat the process with the rest of the string.
     * [3] For the remaining string, find all possible prefixes in the dictionary.
     * Continue this process until the whole string has been processed.
     * [4] After processing the whole string, return TRUE if it could be broken into
     * space-separated dictionary words. Otherwise, return FALSE.
     */

    public WordBreak() {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int stringLength = s.length();

        Set<String> wordSet = new HashSet<>(wordDict);
        // 0 is empty string - hence will need stringLength + 1
        boolean[] memo = new boolean[stringLength + 1];

        // Empty string can always be separated
        memo[0] = true;

        for (int endIndex = 1; endIndex <= stringLength; endIndex++) {
            for (int startIndex = 0; startIndex < endIndex; startIndex++) {
                {
                    String substring = s.substring(startIndex, endIndex);
                    boolean isMatchingWord = wordSet.contains(substring);
                    boolean previousMatchingStatus = memo[startIndex];

                    System.out.println(String.format("Processing (%d, %d): Previous [%d] Matching - %s", startIndex,
                            endIndex, startIndex, previousMatchingStatus));
                    if (previousMatchingStatus && isMatchingWord) {
                        System.out.println(String.format("Processing (%d, %d): Found match for [%s]", startIndex,
                                endIndex, substring));
                        memo[endIndex] = true;
                        break;
                    } else {
                        System.out.println(String.format("Processing (%d, %d): No match for [%s]", startIndex,
                                endIndex, substring));
                    }
                }
            }
        }

        // Replace this placeholder return statement with your code
        return memo[stringLength];
    }
}
