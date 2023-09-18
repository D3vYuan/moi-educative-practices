package com.example.FastSlowPointers;

import java.util.HashMap;
import java.util.Map;

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
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.putIfAbsent(n, 1);

        // Replace this placeholder return statement with your code
        int sum = 0;
        int cycle = 0;
        int remainingValues = n;

        while (remainingValues > 0){
            int current_number = remainingValues % 10;
            sum += current_number * current_number;

            System.out.println(String.format("Processing: Cycle #%d Step - Value (%d) | Current (%d) | Sum (%d)", cycle, remainingValues, current_number, sum));
            remainingValues = remainingValues / 10;
            if (remainingValues == 0){
                if (sum == 1){
                    System.out.println("Processing: End condition matches - Sum is 1 [HappyNumber (true)]");
                    return true;
                }

                remainingValues = sum;
                cycle += 1;                
                if (sumMap.containsKey(remainingValues)){
                    System.out.println(String.format("Processing: Cycle detected - Sum %d already exists [HappyNumber (false)]", sum));
                    return false;
                }
                System.out.println(String.format("Processing: Cycle #%d - Adding Sum (%d) to tracking", cycle, sum));
                sumMap.putIfAbsent(sum, 1);
                sum = 0;
            }

            // if (cycle > 20){
            //     break;
            // }
        }

        return true;
    }
}
