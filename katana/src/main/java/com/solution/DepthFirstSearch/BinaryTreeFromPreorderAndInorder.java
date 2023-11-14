package com.solution.DepthFirstSearch;

import java.util.HashMap;
import java.util.Map;

import com.solution.Utility.TreeNode;

public class BinaryTreeFromPreorderAndInorder {
    /*
     * 
     * Strategy
     * [1] Select the first element from the preorder list. Increment a preorder
     * index variable to prepare for the next recursive call.
     * [2] Create a new tree node with the selected element of the preorder list as
     * its data.
     * [3] Find the index of the selected element in the inorder list and store it
     * in inIndex.
     * [4] Recursively build the left subtree of the root by calling the function on
     * the elements before inIndex in the inorder list.
     * [5] Recursively build the right subtree of the root by calling the function
     * on the elements after inIndex in the inorder list.
     */

    private static TreeNode<Integer> buildTreeHelper(int[] pOrder, int[] iOrder, int left, int right,
            Map<Integer, Integer> mapping, int[] pIndex) {
        if (left > right) {
            return null;
        }

        int curr = pOrder[pIndex[0]];
        pIndex[0]++;
        TreeNode<Integer> root = new TreeNode<Integer>(curr);

        if (left == right) {
            return root;
        }

        int inIndex = mapping.get(curr);

        root.setLeft(buildTreeHelper(pOrder, iOrder, left, inIndex - 1, mapping, pIndex));
        root.setRight(buildTreeHelper(pOrder, iOrder, inIndex + 1, right, mapping, pIndex));

        return root;
    }

    public static TreeNode<Integer> buildTree(int[] pOrder, int[] iOrder) {
        Map<Integer, Integer> mapping = new HashMap<>();
        for (int i = 0; i < iOrder.length; i++) {
            mapping.put(iOrder[i], i);
        }

        int[] pIndex = { 0 };
        return buildTreeHelper(pOrder, iOrder, 0, pOrder.length - 1, mapping, pIndex);
    }
}
