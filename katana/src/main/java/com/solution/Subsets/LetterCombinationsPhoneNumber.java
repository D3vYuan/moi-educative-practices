package com.solution.Subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {
    /*
     * 
     * Strategy
     * [1] Initialize an empty list to store all the combinations.
     * [2] If the input string of digits is empty, return an empty list, since there
     * are no possible combinations.
     * [3] Initialize a dictionary that maps the digits to their corresponding
     * characters.
     * [4] Check if the length of our current combination is the same as the length
     * of the input, add it to the list of results and backtrack.
     * [5] Otherwise, retrieve the list of possible letters corresponding to the
     * digit at the current index and iterate through each letter to generate the
     * combinations recursively.
     */

    // Use backtrack function to generate all possible combinations
    private void backtrack(int index, StringBuilder sb, String digits, Map<Character, String[]> digitsMapping,
            List<String> combinations) {
        // If the length of path and digits is same,
        // we have a complete combination
        if (sb.length() == digits.length()) {
            // Join the path list into a string and add it to combinations list
            combinations.add(sb.toString());
            return; // Backtrack
        }

        // Get the list of letters using the index and digits[index]
        char digit = digits.charAt(index);
        String[] possibleLetters = digitsMapping.get(digit);
        for (String letter : possibleLetters) {
            // Add the current letter to the path
            sb.append(letter);

            // Recursively explore the next digit
            backtrack(index + 1, sb, digits, digitsMapping, combinations);

            // Remove the current letter from the path before backtracking to explore other
            // combinations
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> combinations = new ArrayList<>();

        if (digits.length() == 0) {
            return combinations;
        }

        // Mapping the digits to their corresponding letters
        Map<Character, String[]> digitsMapping = new HashMap<>();
        digitsMapping.put('1', new String[] { "" });
        digitsMapping.put('2', new String[] { "a", "b", "c" });
        digitsMapping.put('3', new String[] { "d", "e", "f" });
        digitsMapping.put('4', new String[] { "g", "h", "i" });
        digitsMapping.put('5', new String[] { "j", "k", "l" });
        digitsMapping.put('6', new String[] { "m", "n", "o" });
        digitsMapping.put('7', new String[] { "p", "q", "r", "s" });
        digitsMapping.put('8', new String[] { "t", "u", "v" });
        digitsMapping.put('9', new String[] { "w", "x", "y", "z" });
        // Initiate backtracking with an empty path and starting index of 0
        backtrack(0, new StringBuilder(), digits, digitsMapping, combinations);

        return combinations;
    }
}
