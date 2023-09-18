package com.example.Backtracking;

public class NQueens {
    /**
     * Given a chessboard of size n×n, determine how many ways n queens can be placed on the board, such that no two queens attack each other.
     * A queen can move horizontally, vertically, and diagonally on a chessboard. One queen can be attacked by another queen if both share the same row, column, or diagonal.
     * 
     * Strategy
     * [1] Start by placing a queen in the first column of the first row of the chess board.
     * [2] Since no other queen may be placed in a row that already has a queen, search for a safe position for the next queen in the next row.
     * [3] Iterate over the rows to find a safe placement for the queens. Store the column number where a queen is placed in a list.
     * [4] If a safe position is not found, backtrack to the previous valid placement. Search for another solution.
     * [5] If a complete solution is found, add it to the results array, and backtrack to find other valid solutions in the same way.
     */
}
