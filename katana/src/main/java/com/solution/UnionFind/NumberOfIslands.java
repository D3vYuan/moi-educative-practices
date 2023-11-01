package com.solution.UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslands {
    /**
     * Let’s consider a scenario with an (m×n) 2D grid containing binary numbers,
     * where '0' represents water and '1' represents land.
     * 
     * If any '1' cells are connected to each other horizontally or vertically (not
     * diagonally),
     * they form an island.
     * 
     * Your task is to return the total number of islands in the grid.
     * Strategy
     * [1] Count all occurrences of cell 1s in the grid and store them in a variable
     * called count.
     * [2] Traverse the grid, and whenever a cell 1 is encountered, check whether
     * this cell 1 has a neighboring cell 1 on its top, bottom, left, or right.
     * [3] Connect all neighboring cell 1s into a single component, subtract the
     * number of neighbors from count, and change the value of cell 1 in the grid to
     * 0.
     * [4] At the end of the traversal, count contains the number of islands.
     */

    class UnionFind {
        private List<List<Character>> grid;
        private List<Integer> parent;
        private List<Integer> rank;
        private int[] visited;
        private int rowSize;
        private int colSize;
        private int count;

        public UnionFind(List<List<Character>> grid) {
            this.grid = grid;
            this.rowSize = grid.size();
            this.colSize = grid.get(0).size();
            this.parent = new ArrayList<>();
            this.rank = new ArrayList<>();
            this.visited = new int[rowSize * colSize];
            this.count = 0;

            Arrays.fill(this.visited, 0);

            // If we encounter a cell 1, we append the current index, i * n + j, of the grid
            // according to the row major order and increment count by
            // If a cell 0 is encountered, we append −1 to the array because cell 0s in the
            // grid will be ignored anyway.
            for (int row = 0; row < rowSize; row++) {
                for (int col = 0; col < colSize; col++) {
                    if (grid.get(row).get(col) == '1') {
                        int majorOrder = getMajorOrder(row, col);
                        System.out.println(String.format("(%d,%d) - Index @%d", row, col, majorOrder));
                        parent.add(majorOrder);
                        this.count += 1;
                    } else {
                        this.parent.add(-1);
                    }
                    this.rank.add(1);
                }
            }
        }

        public Integer getMajorOrder(int row, int col) {
            return row * colSize + col;
        }

        public Integer getRowSize() {
            return this.rowSize;
        }

        public Integer getColumnSize() {
            return this.colSize;
        }

        public Character getValue(int row, int col) {
            Character gridValue = this.grid.get(row).get(col);
            System.out.println(String.format("value(%d, %d): found %s", row, col, gridValue));
            return gridValue;
        }

        public void visited(int row, int col) {
            int index = row * colSize + col;
            visited[index] = 1;
        }

        public List<Integer> getParent() {
            return this.parent;
        }

        // Function to return the number of connected components consisting of 1s
        public int getCount() {
            return this.count;
        }

        // Function to connect components
        public void union(int v1, int v2) {

            int parent1 = find(v1);
            int parent2 = find(v2);
            System.out.println(String.format("union(%d, %d): parent1 (%d) | parent2 (%d)", v1, v2, parent1, parent2));

            // Check if the parent of the current element and its neighbor is different.
            // If so, we connect these two cells and decrement count by 1
            // Otherwise, if their parent is the same,
            // they are already part of a connected component, so we do not decrement count.
            // At the end of the traversal, count will contain the total number of islands.

            if (parent1 != parent2) {
                // The absolute value of the root node represents the size of this union
                // Make the one with larger size be the new parent
                int parent1_rank = this.rank.get(parent1);
                int parent2_rank = this.rank.get(parent2);
                if (parent1_rank > parent2_rank) {
                    System.out.println(String.format("union(%d, %d): adding parent2 (%d) to parent1 (%d)", v1, v2,
                            parent2, parent1));
                    this.parent.set(parent2, parent1);
                    this.rank.set(parent1, parent1_rank + parent2_rank);
                } else if (parent2_rank > parent1_rank) {
                    System.out.println(String.format("union(%d, %d): adding parent1 (%d) to parent2 (%d)", v1, v2,
                            parent1, parent2));
                    this.parent.set(parent1, parent2);
                    this.rank.set(parent2, parent2_rank + parent1_rank);
                } else {
                    System.out.println(String.format("union(%d, %d): adding parent2 (%d) to parent1 (%d)", v1, v2,
                            parent2, parent1));
                    this.parent.set(parent2, parent1);
                    System.out.println(String.format("union(%d, %d): parent1 (%d) ranked up (%d + 1)", v1, v2, parent1,
                            parent1_rank));
                    this.rank.set(parent1, parent1_rank + 1);
                }
                count--;
            }

        }

        // Function to find the root parent of a node
        public int find(int v) {
            System.out.println(String.format("find(%d): found parent - %d", v, this.parent.get(v)));
            if (this.parent.get(v) != v) {
                this.parent.set(v, this.find(this.parent.get(v)));
            }
            return this.parent.get(v);
        }
    }

    public NumberOfIslands() {

    }

    private boolean isValidMove(int row, int col, int totalRow, int totalCol) {
        boolean validRowMovement = row >= 0 && row < totalRow;
        boolean validColMovement = col >= 0 && col < totalCol;
        System.out.println(String.format("valid(%d, %d) - %s", row, col, validRowMovement && validColMovement));
        return validRowMovement && validColMovement;
    }

    public int numIslands(List<List<Character>> grid) {
        int[] rowMovement = new int[] { 0, 0, -1, 1 }; // up, down, left, right
        int[] colMovement = new int[] { -1, 1, 0, 0 };

        if (grid.isEmpty()) {
            return 0;
        }

        UnionFind unionFind = new UnionFind(grid);
        int rows = unionFind.getRowSize();
        int cols = unionFind.getColumnSize();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // If the current cell is a land, then mark it as visited
                System.out.println(String.format("find(%d, %d): processing", row, col));
                if (unionFind.getValue(row, col) == '1') {

                    // unionFind.visited(row, col);
                    int currentMajorOrder = unionFind.getMajorOrder(row, col);
                    System.out.println(
                            String.format("find(%d, %d): found island index @%d", row, col, currentMajorOrder));

                    for (int moveId = 0; moveId < rowMovement.length; moveId++) {
                        int currentRowOffset = rowMovement[moveId];
                        int currentColOffset = colMovement[moveId];

                        int neighbourRow = row + currentRowOffset;
                        int neighbourCol = col + currentColOffset;

                        if (isValidMove(neighbourRow, neighbourCol, rows, cols) &&
                                unionFind.getValue(neighbourRow, neighbourCol) == '1') {
                            int neighborMajorOrder = unionFind.getMajorOrder(neighbourRow, neighbourCol);
                            unionFind.union(currentMajorOrder, neighborMajorOrder);
                        }
                    }

                    // Check the horizontal and vertical neighbors of the current cell
                    // If any of the neighbors are also lands, then unite the current cell with the
                    // neighbor
                }
                System.out.println(String.format("find(%d, %d): processed", row, col));
                System.out.println("--");
            }
        }

        return unionFind.getCount();
    }
}
