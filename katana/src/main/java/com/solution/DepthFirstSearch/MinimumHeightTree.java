package com.solution.DepthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTree {
    /*
     * 
     * Strategy
     * [1] In a circle, the diameter is the longest path from one point to another
     * that passes through the center. Similarly, consider the tree as a circle,
     * where the leaf nodes make up the circumference. We consider the diameter of
     * the tree, that is, the maximum length path between two leaf nodes, where no
     * node is repeated. The center node(s) in this diameter will be the root
     * node(s) from which the height can be minimized.
     * [2] Odd-length chain: The middle node in this chain will be the root node
     * that minimizes the height. This is because the length of the path from this
     * node to the leaf node will be the minimum length path (height). No other node
     * can be selected as the root since it will lead to a longer length path
     * (height) to a leaf node.
     * [3] Even-length chain: The two middle nodes in this chain will be the root
     * nodes that minimize the height. We can select two candidate nodes in this
     * case since an even-length chain does not contain a single middle node. The
     * length of the path from these nodes to the leaf node will be the minimum
     * length path (height).
     */

    private static List<Set<Integer>> constructAdjacencyList(int n, int[][] edges) {
        // Initialize an empty adjacency list with 'n' empty sets
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }

        // Iterate through the 'edges' list and add edges to the adjacency list
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }

        return adj;
    }

    public static List<Integer> minHeightTrees(int n, int[][] edges) {
        // If there are 1 or 2 nodes, return them as the minimum height trees
        if (n <= 2) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }

        // Construct the adjacency list for the graph
        List<Set<Integer>> adj = constructAdjacencyList(n, edges);

        // Initialize a list to store the leaves of the graph
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // Initialize a variable to keep track of remaining nodes
        int remNodes = n;

        // Iterate until there are only 1 or 2 nodes left
        while (remNodes > 2) {
            // Decrement the count of remaining nodes by the number of leaves
            remNodes -= leaves.size();

            // Initialize a temporary list to store new leaves
            List<Integer> nextLeaves = new ArrayList<>();

            while (!leaves.isEmpty()) {
                int leaf = leaves.remove(leaves.size() - 1);

                // Get its neighbor
                int neighbor = adj.get(leaf).iterator().next();
                adj.get(leaf).remove(neighbor);

                // Remove the link from the neighbor back to the leaf
                adj.get(neighbor).remove(leaf);

                // If the neighbor becomes a new leaf, add it to 'tempLeaves'
                if (adj.get(neighbor).size() == 1) {
                    nextLeaves.add(neighbor);
                }
            }

            // Update 'leaves' with the new leaves found in this iteration
            leaves = nextLeaves;
        }

        // Return the remaining nodes as the minimum height trees
        return leaves;
    }
}
