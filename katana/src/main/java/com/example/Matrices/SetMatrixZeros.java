package com.example.Matrices;

public class SetMatrixZeros {
    /**
     * Given a matrix, mat, if any element within the matrix is zero, set that row and column to zero.
     * 
     * Strategy
     * [1] If any element in first row and/or the first column is 0, set frow and fcol to TRUE.
     * [2] Scan the complete matrix row-wise by ignoring the first row and, first column and set 0 in the first element of the particular row and column where 0 is found.
     * [3] Check every row’s first element, starting from second row. If it is 0, then set all values in that row to 0.
     * [4] Check every column’s first element starting from second column. If it is 0, then set all values in that column to 0.
     * [5] If frow and/or fcol is TRUE, set first row or column to 0.
     */

     public SetMatrixZeros(){

     }
}
