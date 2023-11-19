package com.solution.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    /**
     * 
     * Strategy
     * [1] Iterate through the input string to count the occurrences of each
     * character and store these frequencies in a hash map.
     * [2] Iterate through the frequencies in the hash map, and calculate the number
     * of pairs af each character that will appear in the longest palindrome of even
     * length.
     * [3] Multiply the total number af pairs by 2 to find the length of the longest
     * palindrome of even length.
     * [4] If the length of the longest palindrome af even length is less than the
     * length of the input string, increment it by 1 to adjust far the possibility
     * of an add-length palindrome.
     * 
     * Explanation
     * [1] In palindromes of even length, all the characters appear in pairs, while
     * in palindromes of odd length, all the characters other than the middle one
     * appear in pairs. In either case, to maintain the required symmetry, the
     * paired characters must appear at the same distance on either side of the
     * center of the string.
     * [2] Find the maximum number of pairs of characters in the string, plus a
     * unique character that will go in the middle of the palindrome (in the case of
     * odd-length palindromes).
     * [3] Use a hash map to store the characters as keys and their frequencies as
     * values.
     * [4] Next, use the frequencies in the hash map to calculate the length of the
     * palindrome.
     * [5] For any given string, we can first make pairs of characters, which will
     * be added to the result. This count of pairs can be calculated by halving the
     * frequency of each character. Once the pairs are calculated, we have to
     * multiply that count by 2 to find the total number of characters that can be
     * used to make the palindrome.
     * [6] If the calculated length is less than the length of the original input
     * string, it means that at least one character can be added as the center of
     * the palindrome (an odd-length palindrome). In this case, we’ll increment the
     * length by 1 and return the result.
     */

    public static int longestPalindrome(String s) {
        // Create a hash map to count the occurrences of each character
        Map<Character, Integer> charCount = new HashMap<>();
        int length = 0;

        // Iterate through the characters in the string
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Iterate through the counts in the hash map
        for (int count : charCount.values()) {
            // Calculate the length of the palindrome by making pairs
            length += count / 2 * 2;
        }

        // Adjust for odd-length palindrome (one character
        // can be placed in the center of the palindrome)
        if (length < s.length()) {
            length += 1;
        }

        return length;
    }
}
