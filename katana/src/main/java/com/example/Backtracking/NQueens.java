package com.example.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens {
    public NQueens() {

    }

    public void solveNQueensRec(int n, List<Integer> solution, int row, List<List<Integer>> results) {
        if (row == n) {
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
        List<Integer> solution = new ArrayList<Integer>(Collections.nCopies(n, -1));
        solveNQueensRec(n, solution, 0, results);

        System.out.println(String.format("There are [%d] solutions for %d x %d", results.size(), n, n));
        return results.size();
    }

    public boolean isValidMove(int proposedRow, int proposedColumn, List<Integer> solution) {
        int oldRow = 0;
        int oldCol = 0;
        int diagonalOffset = 0;

        // oldCol == proposedCol --> Checks if there are any queens in the proposed
        // column
        // oldCol == proposedCol - diagonalOffset --> Checks if there are any queens on
        // the bottom left diagonal to the proposed place
        // oldCol == proposedCol + diagonalOffset --> Checks if there are any queens on
        // the bottom right diagonal to the proposed place
        for (int i = 0; i < proposedRow; i++) {
            oldRow = i;
            oldCol = solution.get(i);
            diagonalOffset = proposedRow - oldRow;

            boolean queenExistsSameColumn = oldCol == proposedColumn;
            boolean queenExistsBottomLeft = oldCol == proposedColumn - diagonalOffset;
            boolean queenExistsBottomRight = oldCol == proposedColumn + diagonalOffset;

            if (queenExistsSameColumn || queenExistsBottomLeft || queenExistsBottomRight) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new NQueens().solveNQueens(4);
    }
}

