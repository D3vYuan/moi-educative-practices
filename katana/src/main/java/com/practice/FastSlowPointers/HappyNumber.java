package com.practice.FastSlowPointers;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {
    
    
    public HappyNumber(){

    }

    private int sumOfSquaredDigits(int number){
        int totalSum = 0;
        while (number != 0){
            int digit = number % 10;
            number = number / 10;
            totalSum += Math.pow(digit, 2);
        }
        return totalSum;
    }

    public boolean isHappyNumber(int n) {
        int slowPointer = n;
        int fastPointer = sumOfSquaredDigits(n);

        while (fastPointer != 1 && slowPointer != fastPointer){
            slowPointer = sumOfSquaredDigits(slowPointer);
            fastPointer = sumOfSquaredDigits(sumOfSquaredDigits(fastPointer));
        }

        return fastPointer == 1;
    }

    public boolean isHappyNumberV1(int n) {
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
