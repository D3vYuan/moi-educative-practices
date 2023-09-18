package com.example.UnionFind;

public class RedundantConnection {
    /**
     * We’re given an undirected graph consisting of n nodes. 
     * The graph is represented as an array called edges, of length n, where edges[i] = [a, b] indicates that there is an edge between nodes a and b in the graph.
     * 
     * Return an edge that can be removed to make the graph a tree of n nodes. 
     * If there are multiple candidates for removal, return the edge that occurs last in edges.
     * 
     * Strategy
     * [1] Traverse the edges array from the first index to the last index.
     * [2] For each edge, connect the two nodes by marking them. This makes them part of a single connected component.
     * [3] If the current edge connects two nodes that are already marked as part of the connected component, the edge is redundant, so we return it.
     */

     public RedundantConnection() {

     }
}

