package com.practice.Matrices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpiralMatrix {
    /**
     * 
     * Strategy
     * [1] Declare a variable, direction, which stores either 1 (for going left →
     * right and top → bottom) or −1 (for going right → left and bottom → top).
     * Declare two variables, row and col (both initialized to 0), to keep track of
     * the current indexes of the matrix.
     * [2] Start traversing the matrix from the top-left cell.
     * [3] Move horizontally across a row by adding direction to the col variable
     * while keeping row unchanged. Add matrix[row][col] to the result array.
     * [4] Move vertically across a column by adding direction to the row variable
     * while keeping col unchanged. Add matrix[row][col] to the result array.
     * [5] Flip the direction by multiplying the direction variable by −1
     * [6] Repeat this process until all cells have been traversed.
     */

    private static boolean isValidMove(int row, int col, int[][] matrix, int[][] visited) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            System.out.println(String.format("Checking cell validity: (%d, %d) - False", row, col));
            return false;
        }

        if (visited[row][col] == 1) {
            System.out.println(String.format("Checking cell validity: (%d, %d) - False", row, col));
            return false;
        }

        System.out.println(String.format("Checking cell validity: (%d, %d) - True", row, col));
        return true;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        // List<Integer> data = new ArrayList<>();
        // System.out.println("Hello!");
        if (matrix.length <= 0) {
            return new ArrayList<>();
        }

        System.out.println(String.format("Tranversing: Matrix of %d x %d", matrix.length, matrix[0].length));
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // right, down, left, up
        int[][] visited = new int[matrix.length][matrix[0].length];

        int totalVisited = matrix.length * matrix[0].length;

        int matRow = 0;
        int matCol = 0;

        List<Integer> data = new ArrayList<>();
        data.add(matrix[matRow][matCol]);
        visited[matRow][matCol] = 1;
        totalVisited -= 1;

        while (totalVisited > 0) {
            for (int i = 0; i < directions.length; i++) {
                int[] currentDirection = directions[i];
                int currentRowOffset = currentDirection[0];
                int currentColOffset = currentDirection[1];

                int nextRow = matRow + currentRowOffset;
                int nextCol = matCol + currentColOffset;

                // isValidMove(nextRow, nextCol, matrix, visited);
                // break;
                while (isValidMove(nextRow, nextCol, matrix, visited)) {

                    matRow = nextRow;
                    matCol = nextCol;

                    data.add(matrix[matRow][matCol]);
                    visited[matRow][matCol] = 1;
                    totalVisited -= 1;

                    nextRow = matRow + currentRowOffset;
                    nextCol = matCol + currentColOffset;

                    // break;
                }
            }
            // break;
        }

        // String spiralData = "";
        // if (!data.isEmpty()){
        // spiralData =
        data.stream().map(String::valueOf).collect(Collectors.joining(","));
        // }

        // // System.out.println(String.format("Data: %s", spiralData));

        return data;
    }
}