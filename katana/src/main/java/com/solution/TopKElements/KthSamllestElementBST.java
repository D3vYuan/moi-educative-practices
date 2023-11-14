package com.solution.TopKElements;

import com.solution.Utility.TreeNode;

public class KthSamllestElementBST {
    /**
     * 
     * Strategy
     * [1] Start the inorder traversal of the BST.
     * [2] While traversing the BST, decrement k by 1.
     * [3] Check if k has reached 0. If it has, return the value of the current
     * node, containing the kth smallest element.
     * [4] Otherwise, continue the traversal of the BST.
     */

    private static int kthSmallestRec(TreeNode<Integer> node, int[] k) {
        if (node == null) {
            return -1;
        }

        int left = kthSmallestRec(node.getLeft(), k);
        if (left != -1) {
            return left;
        }

        k[0]--;

        if (k[0] == 0) {
            return node.getData();
        }

        return kthSmallestRec(node.getRight(), k);
    }

    public static int kthSmallestElement(TreeNode<Integer> root, int k) {
        int[] kValue = { k };
        // Replace this placeholder return statement with your code
        return kthSmallestRec(root, kValue);
    }
}
