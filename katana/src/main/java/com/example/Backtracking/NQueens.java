package com.example.Backtracking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

     public NQueens(){

     }
     
    public void solveNQueensRec(int n,  List<Integer> solution, int row, List<List<Integer>> results){
        if (row == n){
            results.add(solution);
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean valid = isValidMove(row, i, solution);
            if (valid) {
                solution.set(row, i);
                solveNQueensRec(n, solution, row + 1, results);
            }
            
        }
    }

    public int solveNQueens(int n) {
        List<List<Integer>> results = new ArrayList<>();
		List<Integer> solution = new ArrayList<Integer> (Collections.nCopies(n, -1));
        solveNQueensRec(n, solution, 0, results);
        return results.size();
    }

    public boolean isValidMove(int proposedRow, int proposedColumn, List<Integer> solution){
        int oldRow = 0;
        int oldCol = 0;
        int diagonalOffset = 0;


        // oldCol == proposedCol --> Checks if there are any queens in the proposed column
		// oldCol == proposedCol - diagonalOffset --> Checks if there are any queens on the bottom left diagonal to the proposed place
		// oldCol == proposedCol + diagonalOffset --> Checks if there are any queens on the bottom right diagonal to the proposed place
        for (int i = 0; i < proposedRow; i++) {
            oldRow = i;
            oldCol = solution.get(i);
            diagonalOffset = proposedRow - oldRow;

            boolean queenExistsSameColumn = oldCol == proposedColumn;
            boolean queenExistsBottomLeft =  oldCol == proposedColumn - diagonalOffset;
            boolean queenExistsBottomRight = oldCol == proposedColumn + diagonalOffset;

            if (queenExistsSameColumn || queenExistsBottomLeft || queenExistsBottomRight){
                return false;
            }
        }

        return true;
    }
}
