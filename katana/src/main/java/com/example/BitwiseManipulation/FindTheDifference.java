package com.example.BitwiseManipulation;

public class FindTheDifference {
    /**
     * Given two strings, str1 and str2, find the index of the extra character that
     * is present in only one of the strings.
     * 
     * Strategy
     * [1] Intialize a variable, result, with 0.
     * [2] Perform a bitwise XOR operation between the current value of result and
     * the ASCII value of each character in str1. Update the value of result with
     * the computed XOR value every time.
     * [3] Perform a bitwise XOR operation between the current value of result and
     * the characters of str2. Update the value of result each time with the
     * computed XOR value.
     * [4] result now contains the ASCII value of the extra character. Find and
     * return the index of the extra character from the longer string.
     */
    public FindTheDifference() {
        
    }

    public int extraCharcterIndex(String str1, String str2) {
        int result = 0;

        int str1Length = str1.length();
        int str2Length = str2.length();

        // Traverse the string 1 till the end and perform xor with the result
        for (int str1row = 0; str1row < str1Length; str1row++) {
            result ^= str1.charAt(str1row);
        }

        // Traverse the string 2 till the end and perform xor operation with the result
        for (int str2row = 0; str2row < str2Length; str2row++) {
            result ^= str2.charAt(str2row);
        }

        if (str1Length > str2Length){
            return str1.indexOf((char)(result));
        } else {
            return str2.indexOf((char)(result));
        }
    }
}
