package com.solution.Greedy;

import java.util.Arrays;

public class TwoCityScheduling {
    /**
     * A recruiter plans to hire n people and conducts their interviews at two
     * different locations of the company. He evaluates the cost of inviting
     * candidates to both these locations. The plan is to invite 50% at one
     * location, and the rest at the other location, keeping costs to a minimum.
     * We are given an array, costs, where costs[i]=[aCosti,bCosti],
     * the cost of inviting the ith person to City A is aCosti, and the cost of
     * inviting the same person to City B is bCosti
     * You need to determine the minimum cost to invite all the candidates for the
     * interview such that exactly n/2 people are invited in each city.
     * 
     * Strategy
     * [1] Initialize a variable, total Cost to 0
     * [2] Sort the costs array in ascending order based on the difference between
     * the cost of traveling to City A and City B
     * [3] Iterate over the sorted costs array.
     * [4] Add the cost of the first half of the array to invite to City A and the
     * second half to invite to City B in totalCost
     * [5] Return totalCost after adding the respective costs
     */

    public TwoCityScheduling() {

    }

    public int twoCityScheduling(int[][] costs) {
        // Initialize the total cost to 0
        int totalCost = 0;

        // Sort the costs array in ascending order based on the difference
        // between the costs of sending someone to city A vs city B
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        // Get the length of the costs array
        int costLength = costs.length;

        // For each pair of cities, add the cost of sending one person to city A
        // and the other person to city B to the total cost
        for (int i = 0; i < costLength / 2; i++) {
            totalCost += costs[i][0] + costs[costLength - i - 1][1];
        }

        // Return the total cost
        return totalCost;
    }
}
