package com.solution.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    /**
     * Given two strings, check whether two strings are isomorphic to each other or
     * not.
     * Two strings are isomorphic if a fixed mapping exists from the characters of
     * one string to the characters of the other string.
     * For example, if there are two instances of the character "a" in the first
     * string, both these instances should be converted to another character (which
     * could also remain the same character if "a" is mapped to itself) in the
     * second string.
     * This converted character should remain the same in both positions of the
     * second string since there is a fixed mapping from the character "a" in the
     * first string to the converted character in the second string.
     * 
     * Strategy
     * [1] Create two hash maps. One to store mapping from string1 to string2 and
     * another to store mapping from string2 to string1.
     * [2] Before storing the mapping of characters in the hash maps, first check if
     * the character is present in its hash map.
     * [3] If the character is already in the hash map, and is mapped to a different
     * character in the hash map than the character to be mapped, the algorithm
     * terminates and FALSE is returned.
     * [4] If all the mappings are valid in both the hash maps, TRUE is returned.
     */

    public IsomorphicStrings() {

    }

    public boolean isIsomorphic(String string1, String string2) {
        // Initliazing the hashmaps
        Map<Character, Character> mapStr1Str2 = new HashMap<>();
        Map<Character, Character> mapStr2Str1 = new HashMap<>();

        int i = 0, j = 0;

        while (i < string1.length()) {
            char char1 = string1.charAt(i);
            char char2 = string2.charAt(j);

            // returning false if char1 in string1 exist in hashmap
            // and the char1 has different mapping in hashmap
            if (mapStr1Str2.containsKey(char1) && mapStr1Str2.get(char1) != char2)
                return false;

            // returning false if char2 in string2 exist in hashmap
            // and the char2 has different mapping in hashmap
            if (mapStr2Str1.containsKey(char2) && mapStr2Str1.get(char2) != char1)
                return false;

            // mapping of char of one string to another and vice versa
            mapStr1Str2.put(char1, char2);
            mapStr2Str1.put(char2, char1);

            i++;
            j++;
        }
        return true;
    }
}
