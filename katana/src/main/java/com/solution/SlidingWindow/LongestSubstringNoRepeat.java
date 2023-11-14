package com.solution.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeat {
    /**
     * 
     * Strategy
     * [1] Initialize an empty hash map and a variable to track character indexes
     * and the start of the window, respectively.
     * [2] Traverse the string character by character. For each character, if the
     * hash map does not contain the current character, store it with its index as
     * the value.
     * [3] If the hash map contains the current character and its index falls within
     * the current window, a repeating character is found. Otherwise, store it in
     * the hash map with its index as the value.
     * [4] When a repeating character is found, update the start of window to the
     * previous location of the current element and increment it. Also, calculate
     * the length of the current window.
     * [5] Update the longest substring seen so far if the length of the current
     * window is greater than its current value.
     * [6] Return the length of the longest substring.
     */

    public static int findLongestSubstring(String str) {
        if (str.length() <= 0) {
            return 0;
        }

        int windowStart = 0;
        int longest = 0;
        int windowLength = 0;
        int n = str.length();

        Map<Character, Integer> lastSeenAt = new HashMap<Character, Integer>();
        int i;
        // Traverse input str to find the longest substring
        // without repeating characters.
        for (i = 0; i < n; i++) {
            // If the current element is not present in the hash map,
            // then store it in the hash map with the current index as the value.
            if (!lastSeenAt.containsKey(str.charAt(i))) {
                lastSeenAt.put(str.charAt(i), i);
            } else {
                // If the current element is present in the hash map,
                // it means that this element may have appeared before.
                // Check if the current element occurs before or after `windowStart`.
                if (lastSeenAt.get(str.charAt(i)) >= windowStart) {
                    windowLength = i - windowStart;
                    if (longest < windowLength) {
                        longest = windowLength;
                    }
                }

                windowStart = lastSeenAt.get(str.charAt(i)) + 1;
            }
            // Update the last occurence of
            // the element in the hash table
            lastSeenAt.replace(str.charAt(i), i);
        }

        if (longest < i - windowStart) {
            longest = i - windowStart;
        }

        return longest;
    }
}
