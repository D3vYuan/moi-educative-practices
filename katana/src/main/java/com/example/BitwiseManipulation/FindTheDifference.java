package com.example.BitwiseManipulation;

public class FindTheDifference {
    /**
     * Given two strings, str1 and str2, find the index of the extra character that is present in only one of the strings.
     * 
     * Strategy
     * [1] Intialize a variable, result, with 0.
     * [2] Perform a bitwise XOR operation between the current value of result and the ASCII value of each character in str1. Update the value of result with the computed XOR value every time.
     * [3] Perform a bitwise XOR operation between the current value of result and the characters of str2. Update the value of result each time with the computed XOR value.
     * [4] result now contains the ASCII value of the extra character. Find and return the index of the extra character from the longer string.
     */
}
