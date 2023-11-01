package com.solution.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    /**
     * Given an m×n 2D grid of characters and word as a string,
     * we need to determine if the word can be constructed from letters of
     * sequentially adjacent cells.
     * The cells are considered sequentially adjacent when they are neighbors to
     * each other either horizontally or vertically.
     * The function should return TRUE if the word can be constructed and FALSE
     * otherwise.
     * 
     * Strategy
     * [1] Start traversing the grid from the first cell.
     * [2] Call depth-first search to search for the next character of the search
     * word in the four possible directions for each cell of the grid.
     * [3] If a valid character is found, call the depth-first search function again
     * for this cell.
     * [4] Continue searching through the cells until either the search word is
     * found or all cells in the grid have been visited.
     */

    public WordSearch() {

    }

    private List<int[]> wordLocation;

    // Check for up, down, left, right
    private int[] rowOffset = new int[] { -1, 1, 0, 0 };
    private int[] colOffset = new int[] { 0, 0, -1, 1 };

    private boolean checkNextMatchingWord(int row, int col, char[][] grid, String word) {
        if (word.length() == 0) {
            System.out.println(String.format("Comparing (%d, %s): Word is empty, a match has been found",
                    row, col));
            return true;
        }

        // Handle Out-of-bound Scenario and Non-matching
        boolean rowOutOfBound = row < 0 || row >= grid.length;
        boolean colOutOfBound = col < 0 || col >= grid[0].length;
        if (rowOutOfBound || colOutOfBound) {
            return false;
        }

        char firstWordCharacter = word.charAt(0);
        char currentCellCharacter = grid[row][col];
        System.out.println(String.format("Comparing (%d, %s): Checking cell (%s) match word (%s)",
                row, col, currentCellCharacter, firstWordCharacter));

        if (currentCellCharacter != firstWordCharacter) {
            return false;
        }

        // Check if the current cell match the first letter, proceed to next letter
        wordLocation.add(new int[] { row, col });
        int latestWordLocationIndex = wordLocation.size() - 1 >= 0 ? wordLocation.size() - 1 : 0;
        System.out.println(String.format("Saving Location (%d, %s): Adding to index @(%d)",
                row, col, latestWordLocationIndex));

        boolean hasMatch = false;
        for (int offsetIndex = 0; offsetIndex < rowOffset.length; offsetIndex++) {
            int currentCellRowOffset = rowOffset[offsetIndex];
            int currentCellColOffset = colOffset[offsetIndex];

            int nextRow = row + currentCellRowOffset;
            int nextCol = col + currentCellColOffset;

            hasMatch = checkNextMatchingWord(nextRow, nextCol, grid, word.substring(1));
            if (hasMatch) {
                return hasMatch;
            }
        }

        // No match found - perform backtracking
        if (wordLocation.size() > 0 && !hasMatch) {
            System.out.println(String.format("Removing Location (%d, %s): No match found - Removing from index @(%d)",
                    row, col, wordLocation.size() - 1));
            wordLocation.remove(wordLocation.size() - 1);
            System.out.println(String.format("Backtracking from (%d, %s): No match found from word (%s)",
                    row, col, currentCellCharacter));
        }

        System.out.println("--");
        return hasMatch;
    }

    public boolean wordSearch(char[][] grid, String word) {
        System.out.println(String.format("Searching for word (%s)", word));
        // backtracking - find the first word and do a dfs to check if any occurrences
        int rows = grid.length;
        int cols = grid[0].length;

        wordLocation = new ArrayList<>(word.length());

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean hasMatch = checkNextMatchingWord(row, col, grid, word);
                System.out.println(String.format("Comparing (%d, %d): Match word (%s) - %s", row, col, word, hasMatch));
                if (hasMatch) {
                    return hasMatch;
                }
                System.out.println("--");
            }
        }

        return false;
    }
}
