package com.example.DepthFirstSearch;

import com.example.Utility.TreeNode;

public class FlattenBinaryTree {
    /**
     * Given the root of a binary tree, the task is to flatten the tree into a
     * linked list using the same TreeNode class.
     * The left child pointer of each node in the linked list should always be NULL,
     * and the right child pointer should point to the next node in the linked list.
     * The nodes in the linked list should be in the same order as that of the
     * preorder traversal of the given binary tree.
     * 
     * Strategy
     * [1] For every node, check whether or not it has a left child. If it does not
     * have a left child, we move to the right child.
     * [2] Otherwise, find the node on the rightmost branch of the left subtree that
     * does not have a right child.
     * [3] Once we find this rightmost node, connect it with the right child of the
     * current node. After connecting, set the right child of the current node to
     * the left child of the current node.
     * [4] Finally, set the left child of the current node to NULL.
     * [5] Repeat the process until the given binary tree becomes flattened.
     */

    public FlattenBinaryTree() {

    }

    public static TreeNode<Integer> flattenTree(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        TreeNode<Integer> current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode<Integer> last = current.left;
                while (last.right != null) {
                    last = last.right;
                }

                last.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }

        // Replace this placeholder return statement with your code
        return root;
    }

}
