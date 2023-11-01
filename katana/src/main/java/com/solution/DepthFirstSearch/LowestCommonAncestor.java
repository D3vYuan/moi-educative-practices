package com.solution.DepthFirstSearch;

import com.solution.Utility.TreeNode;

public class LowestCommonAncestor {
    /**
     * Given the root node of a binary tree with n nodes, your task is to find the
     * lowest common ancestor of two of its nodes, p and q.
     * 
     * Note: The lowest common ancestor of two nodes, p and q, is defined as the
     * lowest node in the binary tree that has both p and q as descendants.
     * 
     * A node can also be a descendant of itself. For example, if q is a descendant
     * of p, and we know that p is a descendant of itself, then p will be the lowest
     * common ancestor of p and q.
     * 
     * Strategy
     * [1] Initialize three tracking variables to track if either of the input nodes
     * have been found.
     * [2] Traverse the input binary tree using depth-first search starting from the
     * root node.
     * [3] If, during traversal, the current node is one of the input nodes, set one
     * of the tracking variables to TRUE and continue traversing its children.
     * [4] Store the results of left and right subtrees in the remaining two
     * tracking variables.
     * [5] If any two of the three tracking variables are TRUE at a node, it means
     * that this is lowest common ancestor of the binary tree.
     */
    private TreeNode<Integer> ancestor = null;

    private int boolToInt(boolean val) {
        return (val) ? 1 : 0;
    }

    private boolean lowestCommonAncestorRec(TreeNode<Integer> currentNode, TreeNode<Integer> p,
            TreeNode<Integer> q) {
        if (currentNode == null)
            return false;

        boolean left = false, right = false, mid = false;

        if (p == currentNode || q == currentNode) {
            mid = true;
        }

        left = lowestCommonAncestorRec(currentNode.getLeft(), p, q);

        if (ancestor == null) {
            right = lowestCommonAncestorRec(currentNode.getRight(), p, q);
        }

        if (boolToInt(mid) + boolToInt(left) + boolToInt(right) >= 2) {
            ancestor = currentNode;
        }

        return mid || left || right;
    }

    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        lowestCommonAncestorRec(root, p, q);
        // Replace this placeholder return statement with your code
        return ancestor;
    }
}
