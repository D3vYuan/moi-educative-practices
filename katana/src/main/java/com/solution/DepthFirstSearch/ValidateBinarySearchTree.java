package com.solution.DepthFirstSearch;

import com.solution.Utility.TreeNode;

public class ValidateBinarySearchTree {
    /*
     * 
     * Strategy
     * [1] Initialize a prev variable with negative infinity.
     * [2] Start the inorder traversal of the binary tree.
     * [3] If the value of the current node is smaller than the value of the prev
     * variable, return FALSE.
     * [4] Otherwise, assign the value of the current node to the prev variable.
     * [5] Continue the traversal of the binary tree.
     * [6] If all nodes of the binary tree have been traversed and the value of each
     * node was greater than the value of the prev, return TRUE.
     */

    private static boolean validateBstHelper(TreeNode<Integer> root, long[] prev) {
        if (root == null) {
            return true;
        }

        // If left subtree is not a valid BST, return false
        if (!validateBstHelper(root.getLeft(), prev)) {
            return false;
        }

        // If current node is less than or equal to the previous node, the tree is not a
        // valid BST
        if (root.getData() <= prev[0]) {
            return false;
        }

        prev[0] = root.getData();

        // Checking right subtree
        return validateBstHelper(root.getRight(), prev);
    }

    public static boolean validateBst(TreeNode<Integer> root) {
        long[] prev = { Long.MIN_VALUE };
        return validateBstHelper(root, prev);
    }
}
