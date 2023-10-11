package com.example.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonnaci {
    int[] memo;

    public Fibonnaci() {
    }

    private int calculateBottomUp(int n) {
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    private int calculateTopDown(int n) {
        if (n <= 1) {
            return n;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        System.out.println(String.format("Recursive: fib(%s)", n));
        memo[n] = calculateBottomUp(n - 1) + calculateBottomUp(n - 2);
        System.out.println(String.format("Recursive: fib(%s) - %d", n, memo[n]));

        return memo[n];
    }

    public void getFibonnaci(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[0] = 0;
        memo[1] = 1;

        // int fibNo = calculateTopDown(10);
        int fibNo = 
        (10);
        System.out.println(String.format("The fibNo(%d) is %d", n, fibNo));
    }

    public static void main(String[] args) {
        Fibonnaci fib = new Fibonnaci();
        fib.getFibonnaci(10);
    }
}
