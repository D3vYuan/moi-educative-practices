package com.example.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens_v1 {
    private void printQueenLocations(List<int[]> moves) {
        if (moves.size() <= 0) {
            return;
        }

        System.out.println("");

        System.out.println("-- queen --");
        System.out.println("Current Queen Locations: ");
        for (int row = 0; row < moves.size(); row++) {
            int[] move = moves.get(row);
            System.out.println(String.format("Row #%d: (%d, %d)", row + 1, move[0],
                    move[1]));
        }
        System.out.println("");
    }

    private boolean canPlaceQueen(int row, int col, List<int[]> moves) {
        if (moves.size() <= 0) {
            return true;
        }
        // Check Row, Col and Diagonal Left and Right that no queen is around
        printQueenLocations(moves);
        boolean canPlace = true;
        for (int[] queenLocation : moves) {
            int queenRow = queenLocation[0];
            int queenCol = queenLocation[1];
            int diagonalOffset = row - queenRow;
            int queenDiagonalLeftRow = row - diagonalOffset;
            int queenDiagonalLeftCol = col - diagonalOffset;
            int queenDiagonalRightRow = row - diagonalOffset;
            int queenDiagonalRightCol = col + diagonalOffset;

            boolean isRowBlock = row == queenRow;
            boolean isColBlock = col == queenCol;
            boolean isDiagonalLeftBlock = (queenDiagonalLeftRow == queenRow &&
                    queenDiagonalLeftCol == queenCol);
            boolean isDiagonalRightBlock = (queenDiagonalRightRow == queenRow &&
                    queenDiagonalRightCol == queenCol);

            if (isRowBlock || isColBlock || isDiagonalLeftBlock || isDiagonalRightBlock) {
                System.out
                        .println(String.format(
                                "Row #%d: Location @ (%d, %d) blocked by Queen at (%d, %d)",
                                row, row, col, queenRow, queenCol));
                return false;
            }
            System.out
                    .println(String.format(
                            "Row #%d: Location @ (%d, %d) NOT blocked by Queen at (%d, %d)",
                            row, row, col, queenRow, queenCol));
        }

        return canPlace;
    }

    private boolean solvePuzzle(int row, int n, List<int[]> moves,
            List<List<int[]>> solutions) {
        // Base Case
        if (row >= n) {
            solutions.add(new ArrayList<>(moves));
            return true;
        }

        for (int col = 0; col < n; col++) {
            if (canPlaceQueen(row, col, moves)) {
                // Track Moves
                moves.add(new int[] { row, col });
                System.out.println(String.format("Row #%d: Adding Queen @ Location (%d, %d)",
                        row, row, col));
                // Recurse to find subset problem
                boolean solve = solvePuzzle(row + 1, n, moves, solutions);
                if (solve) {
                    System.out.println(String.format(
                            "Row #%d: Solution Found, Looking For Alternatives...Removing Queen @Location (%d, %d)",
                            row, row, col));
                    moves.remove(moves.size() - 1);
                } else {
                    // Backtrack
                    System.out.println(
                            String.format(
                                    "Row #%d: No Solution Found, Backtracking...Removing Queen @ Location (%d, %d)",
                                    row, row, col));
                    moves.remove(moves.size() - 1);
                }
            }
        }

        return solutions.size() > 0;
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
        List<int[]> moves = new ArrayList<>();
        solvePuzzle(0, n, moves, solutions);

        System.out.println(String.format("There are [%d] solutions for %dx%d",
                solutions.size(), n, n));
        showSolutions(solutions);
        return solutions.size();
    }

    public static void main(String[] args) {
        new NQueens_v1().solveNQueens(4);
    }
}
