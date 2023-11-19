package com.solution.DynamicProgramming;

public class UniquePaths {
    /**
     * 
     * Strategy
     * [1] Solving the simplest cases along the first row and first
     * column because there's only one way to reach them.
     * [2] Save these solutions and then use them to find solutions for other cells
     * by adding up the values from the cell above and the cell to the left.
     * [3] Create a 2D array, grid, to store the results of smaller
     * subproblems and then combine these results to get the final answer. We
     * initialize grid with all because this will automatically cover the base case
     * of having in the cells of the first row and column. To iteratively fill the
     * values of each subsequent cell, we then traverse each cell of the grid and
     * use the following recurrence relation:
     * - grid[row][col] = grid[row-1][col] + grid[row][col-1]
     * [4] This is because the robot can only move either down or right. Therefore,
     * the total number of ways to reach the current cell is the sum of the ways to
     * reach the cell above it and the ways to reach the cell to its left.
     */
    public static int uniquePaths(int m, int n) {
        // Create a 2D grid, representing paths to each cell
        int[][] grid = new int[m][n];

        // Iterate through each row and column (excluding the first) in the grid
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 || col == 0) {
                    // Initialize the first row and the first column to 1
                    grid[row][col] = 1;
                } else {
                    // Calculate the number of unique paths to the current cell
                    // by summing up paths from the cell above and the cell to the left
                    grid[row][col] = grid[row - 1][col] + grid[row][col - 1];
                }
            }
        }

        // Return the number of unique paths to the last cell (bottom-right corner)
        return grid[m - 1][n - 1];
    }
}
