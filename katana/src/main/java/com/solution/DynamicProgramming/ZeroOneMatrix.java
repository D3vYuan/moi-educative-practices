package com.solution.DynamicProgramming;

public class ZeroOneMatrix {
    /*
     * 
     * Strategy
     * [1] Iterate through the matrix and check for the non-zero elements.
     * [2] At each nonzero element, take the minimum of the element above and to its
     * left and add 1 to the result. Now store the updated result to the current
     * cell.
     * [3] Traverse the whole matrix from the top-left element to the bottom-right
     * element, and update each nonzero element using the same procedure.
     * [4] Next, starting from bottom-right element, iterate to the top-left
     * element, looking for even shorter paths to the nearest 0.
     * [5] While iterating backward, take the minimum of the element below and to
     * the right of the current cell and add 1. Let’s call it the cell’s “candidate
     * distance.”
     * [6] Then, store the lower of the current cell value and its candidate
     * distance in the current cell.
     */

    public int[][] updateMatrix(int[][] mat) {

        int matRow = mat.length;
        int matCol = mat[0].length;

        // First pass: Top-left to bottom-right
        for (int row = 0; row < matRow; row++) {
            for (int col = 0; col < matCol; col++) {
                // Check if the element is greater than zero
                if (mat[row][col] > 0) {
                    // Check the element above, if there is no element above, set to infinity
                    int up = (row > 0) ? mat[row - 1][col] : Integer.MAX_VALUE - 10000;
                    // Check the left element, if there is no left element, set to infinity
                    int left = (col > 0) ? mat[row][col - 1] : Integer.MAX_VALUE - 10000;
                    // Update the current element with the minimum of element above and to its left,
                    // + 1
                    mat[row][col] = Math.min(up, left) + 1;
                }
            }
        }

        // Second pass: Bottom-right to top-left
        for (int row = matRow - 1; row >= 0; row--) {
            for (int col = matCol - 1; col >= 0; col--) {
                // Check if the element is greater than zero
                if (mat[row][col] > 0) {
                    // Check the element below, if there is no element below, set to infinity
                    int down = (row < matRow - 1) ? mat[row + 1][col] : Integer.MAX_VALUE - 10000;

                    // Check the right element, if there is no right element, set to infinity
                    int right = (col < matCol - 1) ? mat[row][col + 1] : Integer.MAX_VALUE - 10000;

                    // Update the current element with the minimum of its value, element below and
                    // to its right, + 1
                    int result = Math.min(down + 1, right + 1);
                    mat[row][col] = Math.min(mat[row][col], result);
                }
            }
        }

        // Check if the element is greater than zero
        // Check the element below, if there is no element below, set to infinity
        // Check the right element, if there is no right element, set to infinity
        // Update the current element with the minimum of its value, element below and
        // to its right, + 1

        return mat;
    }
}
