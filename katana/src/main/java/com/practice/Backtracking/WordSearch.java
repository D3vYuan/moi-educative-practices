package com.practice.Backtracking;

public class WordSearch {

    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // right, up, left, down

    private static boolean dfs(int row, int col, String word, char[][] grid) {
        // word found
        if (word.length() == 0) {
            return true;
        }

        // check boundary
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] != word.charAt(0)) {
            return false;
        }

        boolean result = false;
        grid[row][col] = '*';

        for (int[] direction : directions) {
            int rowOffset = direction[0];
            int colOffset = direction[1];
            result = dfs(row + rowOffset, col + colOffset, word.substring(1), grid);

            if (result) {
                break;
            }
        }

        grid[row][col] = word.charAt(0);
        return result;
    }

    public static boolean wordSearch(char[][] grid, String word) {
        int gridRow = grid.length;
        int gridCol = grid[0].length;
        for (int row = 0; row < gridRow; row++) {
            for (int col = 0; col < gridCol; col++) {
                if (dfs(row, col, word, grid)) {
                    return true;
                }
            }
        }
        return false;
    }
}
