package com.solution.Utility;

public class UnionFind {
    private int[] parents;

    public UnionFind(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int find(int node) {
        if (parents[node] == node) {
            return node;
        }
        return find(parents[node]);
    }

    public void union(int node1, int node2) {
        int rootNode1 = find(node1);
        int rootNode2 = find(node2);
        if (rootNode1 != rootNode2) {
            parents[rootNode2] = rootNode1;
        }
    }
}
