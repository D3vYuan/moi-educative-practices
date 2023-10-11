package com.example.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens_v2 {
    /**
     * Given a chessboard of size n×n, determine how many ways n queens can be
     * placed on the board, such that no two queens attack each other.
     * A queen can move horizontally, vertically, and diagonally on a chessboard.
     * One queen can be attacked by another queen if both share the same row,
     * column, or diagonal.
     * 
     * Strategy
     * [1] Start by placing a queen in the first column of the first row of the
     * chess board.
     * [2] Since no other queen may be placed in a row that already has a queen,
     * search for a safe position for the next queen in the next row.
     * [3] Iterate over the rows to find a safe placement for the queens. Store the
     * column number where a queen is placed in a list.
     * [4] If a safe position is not found, backtrack to the previous valid
     * placement. Search for another solution.
     * [5] If a complete solution is found, add it to the results array, and
     * backtrack to find other valid solutions in the same way.
     */

    public NQueens_v2() {

    }

    private boolean isValid(int row, int col, int space, List<int[]> stack) {
        if (stack.isEmpty()) {
            return true;
        }

        int currentRow = row;
        int currentCol = col;

        if (currentRow < 0 || currentRow > space || currentCol < 0 || currentCol > space) {
            return false;
        }

        // Check that all the location are available
        for (int i = 0; i < stack.size(); i++) {
            int[] queenCell = stack.get(i);
            int queenRow = queenCell[0];
            int queenCol = queenCell[1];
            int diagonalOffset = currentRow - queenRow;
            int diagonalLeftCol = currentCol - diagonalOffset;
            int diagonalRightCol = currentCol + diagonalOffset;

            boolean isColBlock = currentCol == queenCol;
            boolean isDiagLeftBlock = diagonalLeftCol == queenCol;
            boolean isDiagRightBlock = diagonalRightCol == queenCol;

            if (isColBlock || isDiagLeftBlock || isDiagRightBlock) {
                return false;
            }
        }

        return true;
    }

    private boolean reachFinalSolution(List<int[]> stack, List<List<int[]>> solutions) {
        // final solution found
        if (stack.size() == 4) {
            solutions.add(new ArrayList<>(stack));
            System.out.println("-- solution found --");
            System.out.println();
            return true;
        }
        return false;
    }

    private void findNextBestFit(List<int[]> stack, int space) {
        boolean nextFit = false;
        while (!nextFit && !stack.isEmpty()) {
            int[] currentCell = stack.get(stack.size() - 1);
            int currentRow = currentCell[0];
            int currentCol = currentCell[1];

            // See any potential for other column of the same row to place the queen
            System.out
                    .println(String.format("[Removing] Removing Queen at (%d, %d)", currentRow, currentCol));
            stack.remove(stack.size() - 1);
            for (int col = currentCol + 1; col < space; col++) {
                nextFit = isValid(currentRow, col, space, stack);
                if (nextFit) {
                    System.out
                            .println(String.format("[Backtracking] Adding Queen at (%d, %d)", currentRow, col));
                    stack.add(new int[] { currentRow, col });
                    break;
                }
            }
        }
    }

    private boolean solveNQueensHelper(int row, int space, List<List<int[]>> solutions, List<int[]> stack) {
        // Initialize with first element
        System.out.println(String.format("[Traverse] Adding Queen at (%d, %d)", row, 0));
        stack.add(new int[] { row, 0 });
        while (!stack.isEmpty()) {
            int[] currentItem = stack.get(stack.size() - 1);
            int currentRow = currentItem[0];
            int currentCol = currentItem[1];

            // Edge Cases: Reach Final Solution
            boolean finalSolution = reachFinalSolution(stack, solutions);

            // Edge Cases: Row/Col is more than maximum
            if (currentRow > space || currentCol > space || finalSolution) {
                findNextBestFit(stack, space);
                continue;
                
            }

            // Check Next Row Any Valid -
            int nextRow = currentItem[0] + 1;
            boolean nextRowValid = false;
            for (int col = 0; col < space; col++) {
                nextRowValid = isValid(nextRow, col, space, stack);
                if (nextRowValid) {
                    stack.add(new int[] { nextRow, col });
                    System.out.println(String.format("[Traverse] Adding Queen at (%d, %d)", nextRow, col));
                    break;
                }
            }

            if (nextRowValid)
                continue;

            findNextBestFit(stack, space);
        }
        return false;
    }

    private void showSolutions(List<List<int[]>> solutions) {
        if (solutions.size() <= 0) {
            return;
        }

        for (int slnIndex = 0; slnIndex < solutions.size(); slnIndex++) {
            List<int[]> solution = solutions.get(slnIndex);
            System.out.println(String.format("-- Solution %d --", slnIndex));
            for (int[] cell : solution) {
                System.out.println(String.format("Queen @ (%d, %d)", cell[0], cell[1]));
            }
            System.out.println();
        }
    }

    public int solveNQueens(int n) {
        List<List<int[]>> solutions = new ArrayList<>();
        List<int[]> stack = new ArrayList<>();
        solveNQueensHelper(0, n, solutions, stack);
        System.out.println(String.format("There are [%d] solutions for %d x %d", solutions.size(), n, n));
        showSolutions(solutions);
        return solutions.size();
    }

    public static void main(String[] args) {
        new NQueens_v2().solveNQueens(4);
    }
}
