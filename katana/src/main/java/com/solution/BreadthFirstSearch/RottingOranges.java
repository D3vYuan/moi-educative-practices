package com.solution.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static int minMinutesToRot(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // Four possible directions

        Queue<int[]> rottenQueue = new LinkedList<>();
        int freshOranges = 0;
        int minutes = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 2) { // rotten orange
                    rottenQueue.add(new int[] { row, col });
                } else if (grid[row][col] == 1) {
                    freshOranges += 1;
                }
            }
        }

        while (!rottenQueue.isEmpty()) {
            // Determine the number of oranges in the current queue (for this minute)
            int currentMinutesOraanges = rottenQueue.size();

            for (int i = 0; i < currentMinutesOraanges; i++) {
                int[] currentRotten = rottenQueue.poll();
                int currentRottenRow = currentRotten[0];
                int currentRottenCol = currentRotten[1];

                for (int[] direction : directions) {
                    int neighbourRow = currentRottenRow + direction[0];
                    int neighbourCol = currentRottenCol + direction[1];

                    // Check if the neighboring cell is within bounds and contains a fresh orange
                    if (neighbourRow >= 0 && neighbourRow < rows && neighbourCol >= 0 && neighbourCol < cols
                            && grid[neighbourRow][neighbourCol] == 1) {
                        grid[neighbourRow][neighbourCol] = 2;
                        freshOranges -= 1;
                        rottenQueue.add(new int[] { neighbourRow, neighbourCol });
                    }
                }
            }

            // Increment the minutes elapsed as a minute has passed
            minutes += 1;
        }
        // If there are still fresh oranges left, return -1; otherwise, return the
        // minutes elapsed
        return (freshOranges > 0) ? -1 : Math.max(0, minutes - 1);
    }
}
