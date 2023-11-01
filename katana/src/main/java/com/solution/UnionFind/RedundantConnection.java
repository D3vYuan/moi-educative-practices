package com.solution.UnionFind;

import java.util.Arrays;

public class RedundantConnection {
    /**
     * We’re given an undirected graph consisting of n nodes.
     * The graph is represented as an array called edges, of length n, where
     * edges[i] = [a, b] indicates that there is an edge between nodes a and b in
     * the graph.
     * 
     * Return an edge that can be removed to make the graph a tree of n nodes.
     * If there are multiple candidates for removal, return the edge that occurs
     * last in edges.
     * 
     * Strategy
     * [1] Traverse the edges array from the first index to the last index.
     * [2] For each edge, connect the two nodes by marking them. This makes them
     * part of a single connected component.
     * [3] If the current edge connects two nodes that are already marked as part of
     * the connected component, the edge is redundant, so we return it.
     */
    class UnionFind {

        public int[] parent;
        public int[] rank;

        // Constructor
        public UnionFind(int n) {

            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        // Function to find which subset a particular element belongs to
        public int find(int v) {
            if (parent[v] != v) {
                parent[v] = find(parent[v]);
            }
            return parent[v];
        }

        // Function to join two subsets into a single subset
        public boolean union(int v1, int v2) {

            System.out.println("\n\n\tChecking if the vertices have the same parent");
            System.out.println("\t\tEdge: [" + v1 + ", " + v2 + "]");
            System.out.println("\t\tFirst vertex: " + v1);
            System.out.println("\t\tSecond vertex: " + v2);

            // Find the root parents of v1 and v2
            int p1 = find(v1);
            int p2 = find(v2);
            System.out.println("\t\t\tParent of the first vertex: " + p1);
            System.out.println("\t\t\tParent of the second vertex: " + p2);

            // If both parents are the same, a cycle exists and v1,v2 is the redundant edge
            if (p1 == p2) {
                System.out.println("\t\tSince both vertices have the same parent, this is a redundant edge");
                return false;
            }

            /**
             * If both v1 and v2 have the same parent, i.e., p1 is equal to p2, the given
             * edge is redundant, so we return FALSE.
             * Otherwise, this edge is connecting two vertices that were not already
             * connected.
             * So, we’ll update the parent list by making a connection based on the current
             * edge and then return TRUE.
             */
            // Updates the parent and rank lists otherwise
            else if (rank[p1] > rank[p2]) {

                System.out.println("\t\tThe vertices don't have the same parent, updating parent and rank arrays");

                System.out.print("\t\t\tparent: " + Arrays.toString(parent) + " ⟶ ");
                parent[p2] = p1;
                System.out.println(Arrays.toString(parent));

                System.out.print("\t\t\trank: " + Arrays.toString(rank) + " ⟶ ");
                rank[p1] += rank[p2];
                System.out.println(Arrays.toString(rank));
            }

            else {

                System.out.println("\t\tThe vertices don't have the same parent, updating parent and rank arrays");

                System.out.print("\t\t\tparent: " + Arrays.toString(parent) + " ⟶ ");
                parent[p1] = p2;
                System.out.println(Arrays.toString(parent));

                rank[p2] += rank[p1];
                System.out.print("\t\t\trank: " + Arrays.toString(rank) + " ⟶ ");
                System.out.println(Arrays.toString(rank));
            }

            return true;
        }
    }

    public RedundantConnection() {

    }

    public int[] redundantConnection(int[][] edges) {

        UnionFind connections = new UnionFind(edges.length);
        System.out.println("\t\tparent: " + Arrays.toString(connections.parent));
        System.out.println("\t\trank: " + Arrays.toString(connections.rank));

        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            if (!connections.union(v1, v2)) {
                return edge;
            }
        }

        return new int[] {};
    }
}
