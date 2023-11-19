package com.solution.Matrices;

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

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = -1;
        int direction = 1;
        List<Integer> result = new ArrayList<>();

        while (rows > 0 && cols > 0) {
            for (int i = 0; i < cols; i++) {
                col += direction;
                result.add(matrix[row][col]);
            }
            rows--;

            for (int i = 0; i < rows; i++) {
                row += direction;
                result.add(matrix[row][col]);
            }
            cols--;

            direction *= -1;
        }

        return result;
    }
}