package com.solution.Matrices;

import java.util.Arrays;

public class SetMatrixZeros {
    /**
     * Given a matrix, mat, if any element within the matrix is zero, set that row
     * and column to zero.
     * 
     * Strategy
     * [1] If any element in first row and/or the first column is 0, set frow and
     * fcol to TRUE.
     * [2] Scan the complete matrix row-wise by ignoring the first row and, first
     * column and set 0 in the first element of the particular row and column where
     * 0 is found.
     * [3] Check every row’s first element, starting from second row. If it is 0,
     * then set all values in that row to 0.
     * [4] Check every column’s first element starting from second column. If it is
     * 0, then set all values in that column to 0.
     * [5] If frow and/or fcol is TRUE, set first row or column to 0.
     */

    public SetMatrixZeros() {

    }

    public int[][] setMatrixZeros(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        boolean fcol = false;
        boolean frow = false;

        // Check if there is a zero in the first column, set fcol to true.
        for (int row = 0; row < rows; row++) {
            if (mat[row][0] == 0) {
                fcol = true;
                break;
            }
        }

        // Check if there is a zero in the first row, set frow to true.
        for (int col = 0; col < cols; col++) {
            if (mat[0][col] == 0) {
                frow = true;
                break;
            }
        }

        // Check row elements (by ignoring the first row and first column).
        // If zero is found, set the corresponding row's and column's first element to
        // zero.
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (mat[row][col] == 0) {
                    mat[0][col] = 0;
                    mat[row][0] = 0;
                }
            }
        }

        // Check every row's first element starting from the second row.
        // Set the complete row to zero if zero is found.
        for (int row = 1; row < rows; row++) {
            if (mat[row][0] == 0) {
                Arrays.fill(mat[row], 0);
            }
        }

        // Check every column's first element starting from the second column.
        // Set the complete column to zero if zero is found.
        for (int col = 1; col < cols; col++) {
            if (mat[0][col] == 0) {
                for (int row = 1; row < rows; row++) {
                    mat[row][col] = 0;
                }
            }
        }

        // If fcol is true, set the first column to zero.
        if (fcol) {
            for (int row = 0; row < rows; row++) {
                mat[row][0] = 0;
            }
        }

        // If frow is true, set the first row to zero.
        if (frow) {
            Arrays.fill(mat[0], 0);
        }

        return mat;
    }

}
