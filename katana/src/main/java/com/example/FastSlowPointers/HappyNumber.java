package com.example.FastSlowPointers;

public class HappyNumber {
    /**
     * Write an algorithm to determine if a number n is a happy number.
     * We use the following process to check if a given number is a happy number:
     * Starting with the given number n, replace the number with the sum of the squares of its digits.
     * Repeat the process until:
     *  The number equals 1, which will depict that the given number n is a happy number.
     *  It enters a cycle, which will depict that the given number n is not a happy number.
     * Return TRUE if n is a happy number, and FALSE if not.
     * 
     * Strategy
     * [1] Initialise a variable slow with the input number and fast with the squared sum of the input number's digits.
     * [2] If is not 1 and also not equal to slow, increment slow by one iteration and fast by two iterations. Essentially, set slow to Sum of Digits(slow) and fast to Sum of Digits(Sum of Digits (fast)).
     * [3] If fast" converges to 1, return TRUE, otherwise return FALSE.
     */
    
    public HappyNumber(){

    }

    public boolean isHappyNumber(int n) {

        // Replace this placeholder return statement with your code
    
        return true;
    }
}
