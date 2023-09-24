package com.example.Tracking;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    /**
     * For a given string, find whether or not a permutation of this string is a palindrome. 
     * You should return TRUE if such a permutation is possible and FALSE if it isn’t possible.
     * 
     * Strategy
     * [1] Traverse the input string starting from the first character.
     * [2] Populate a hash map with the characters in the string, along with the frequency of occurrence of each character.
     * [3] Traverse the hash map to get the count of characters with an odd number of occurrences.
     * [4] If the count exceeds 1, no palindromic permutation exists.
     */

    Map<Character, Integer> characterCount = new HashMap<>();

     public PalindromePermutation(){

     }

     public boolean permutePalindrome(String st) {
        // If no characters appear an odd number of times, then the string is of even length and has a permutation that is a palindrome.
        // If only one character appears an odd number of times, then the string is of odd length and has a permutation that is a palindrome.
        // If more than one character appears an odd number of times, then the string does not have a permutation that is a palindrome.
    
        for (Character c : st.toCharArray()){
            if (!characterCount.containsKey(c)){
                characterCount.put(c, 1);
            } else {
                characterCount.put(c, characterCount.get(c) + 1);
            }
        }

        int oddOccurrencesCount = 0;

        for (Map.Entry<Character, Integer> entry : characterCount.entrySet()){
            Integer value = entry.getValue();

            if (value % 2 != 0){
                oddOccurrencesCount += 1;
            }
        }

        if (oddOccurrencesCount <= 1){
            return true;
        }

        return false;
    }
     
}
