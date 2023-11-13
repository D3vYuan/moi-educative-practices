package com.practice.DynamicProgramming;

import java.util.Arrays;

public class Knapsack {
    private int[][] memo;

    public int findMaxKnapsackProfit(int capacity, int n, int[] weights, int[] values) {

        memo = new int[n + 1][capacity + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int w = 1; w < capacity + 1; w++) {
                // whether to take item 'i' or not
                int notTakingItem = memo[i - 1][w];
                int takingItem = 0;

                if (weights[i] <= w) {
                    takingItem = values[i] + memo[i - 1][w - weights[i]];
                }

                memo[i][w] = Math.max(takingItem, notTakingItem);
            }
        }

        showItemTaken(n, capacity, weights);
        return memo[n][capacity];
    }

    private void showItemTaken(int n, int capacity, int[] weights) {
        System.out.println("Max Profit: " + memo[n][capacity]);
        for (int i = n, w = capacity; i > 0; i--) {
            if (memo[i][w] != 0 && memo[i][w] != memo[i - 1][w]) {
                System.out.println("Item #" + i + " is taken");
                w = w - weights[i];
            }
        }
    }

    public static void main(String[] args) {
        int numOfItems = 4;
        int capacity = 7;

        int[] weights = { 0, 1, 3, 4, 5 };
        int[] profits = { 0, 1, 4, 5, 7 };

        Knapsack ks = new Knapsack();
        ks.findMaxKnapsackProfit(capacity, numOfItems, weights, profits);
    }
}
