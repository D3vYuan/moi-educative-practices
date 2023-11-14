package com.solution.DepthFirstSearch;

import com.solution.Utility.TreeNode;

public class BinarySearchTreeLowestCommonAncestor {
    /**
     * 
     * Strategy
     * [1] Start traversing from the root of the binary search tree.
     * [2] Compare the values of node1 and node2 with the current node’s value.
     * [3] If both values are greater, move to the right child. If both values are
     * smaller, move to the left child.
     * [4] Otherwise, if the current node’s value is between the values of node1 and
     * node2, return the current node as the lowest common ancestor.
     * [5] Continue the traversal until the LCA is found.
     */

    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> node1,
            TreeNode<Integer> node2) {
        TreeNode<Integer> current = root;

        while (current != null) {
            // If both node1 and node2 are greater than the parent, move current to right
            if (node1.getData() > current.getData() && node2.getData() > current.getData()) {
                current = current.getRight();
            } // If both node1 and node2 are lesser than the parent, move current to left
            else if (node1.getData() < current.getData() && node2.getData() < current.getData()) {
                current = current.getLeft();
            } // We have found the split point, i.e. the lowest common ancestor (LCA) node.
            else {
                return current;
            }

            return null;
        }
        // Replace this placeholder return statement with your code
        return null;
    }
}
