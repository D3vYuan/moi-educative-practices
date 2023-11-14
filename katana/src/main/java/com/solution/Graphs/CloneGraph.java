package com.solution.Graphs;

import java.util.HashMap;
import java.util.Map;

import com.solution.Utility.Node;

public class CloneGraph {
    /*
     * 
     * Strategy
     * [1] Create a new Node with the same data as the root of the original graph.
     * [2] Add the root node and its clone to a hash map.
     * [3] Iterate through the neighbors of the root node.
     * [4] If the neighbor is not cloned yet, recursively clone it. If the neighbor
     * is already cloned, add it to the new node’s neighbors.
     * [5] Return the root of the new graph.
     */

    private static Node cloneHelper(Node root, Map<Node, Node> nodesCompleted) {
        if (root == null) {
            return null;
        }

        Node clonedNode = new Node(root.getData());
        nodesCompleted.put(root, clonedNode);

        for (Node p : root.getNeighbors()) {
            Node x = nodesCompleted.get(p);
            if (x == null) {
                clonedNode.getNeighbors().add(cloneHelper(p, nodesCompleted));
            } else {
                clonedNode.getNeighbors().add(x);
            }
        }
        return clonedNode;
    }

    public static Node clone(Node root) {
        Map<Node, Node> nodesCompleted = new HashMap<>();
        return cloneHelper(root, nodesCompleted);
    }
}
