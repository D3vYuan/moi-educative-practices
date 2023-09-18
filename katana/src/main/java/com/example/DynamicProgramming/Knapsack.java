package com.example.DynamicProgramming;

public class Knapsack {
    /**
     * You are given n items whose weights and values are known, as well as a knapsack to carry these items. The knapsack cannot carry more than a certain maximum weight, known as its capacity.
     * You need to maximize the total value of the items in your knapsack, while ensuring that the sum of the weights of the selected items does not exceed the capacity of the knapsack.
     * If there is no combination of weights whose sum is within the capacity constraint, return 
     * 
     * Strategy
     * [1] Create a 2D table to store the maximum profit for each item and capacity.
     * [2] Initialize the table with 0s for the first row and column to handle base cases.
     * [3] Iterate over the remaining rows and columns of the table, filling them in based on whether the weight of an item is less than or equal to the current capacity.
     * [4] If the weight is less than or equal to the current capacity, use the maximum value that can be obtained by either including or excluding the item. Otherwise, exclude the item and use the previous best value at that capacity.
     * [5] Return the value in the last row and column of the table, which represents the maximum value that can be obtained with the given capacity and items.
     */
}
