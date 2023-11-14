package com.solution.Backtracking;

public class FloodFill {
    /*
     * 
     * [Strategy]
     * [1] For the given source coordinates, check whether the adjacent cells have
     * the same value as this cell.
     * [2] If any matching coordinate is found, update the value of that cell with
     * the given target value and proceed to the next cell.
     * [3] Check the adjacent coordinates one by one. If they have the same value as
     * the starting cell, keep updating them by replacing the cell’s values with the
     * target value.
     * [4] Return the updated grid after replacing the values of the cells that
     * match the source cell’s value.
     */

    static int[][] directions = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } }; // up, right, down, left

    private static void dfs(int[][] grid, int row, int col, int oldTarget, int target) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;

        for (int[] direction : directions) {
            // Calculate the row and column indices of the adjacent cells
            int neighbourRow = row + direction[0];
            int neighbourCol = col + direction[1];

            // If the adjacent cell is within the bounds of the grid and has the same value
            // as the starting cell
            if (neighbourRow < totalRows && neighbourRow >= 0 && neighbourCol < totalCols && neighbourCol >= 0
                    && grid[neighbourRow][neighbourCol] == oldTarget) {
                // Replace the value of the adjacent cell with the specified target
                grid[neighbourRow][neighbourCol] = target;

                // Recursively call the DFS() function on the adjacent cell to repeat the
                // process
                dfs(grid, neighbourRow, neighbourCol, oldTarget, target);
            }
        }
    }

    public static int[][] floodFill(int[][] grid, int sr, int sc, int target) {
        // If the source cell already has the same value as `target`, return the
        // original grid.
        // We don't need to iterate through the whole grid in this case.
        if (grid[sr][sc] == target) {
            return grid;
        } else {
            // Storing the original value of the starting cell in `old_target`,
            // this will help in matching the values of the neighboring cells
            int oldTarget = grid[sr][sc];

            // Replacing the value of the starting cell with the specified target
            grid[sr][sc] = target;

            // Calling the DFS() function on the starting cell to replace the values of all
            // connected cells
            dfs(grid, sr, sc, oldTarget, target);
            return grid;
        }
    }
}
