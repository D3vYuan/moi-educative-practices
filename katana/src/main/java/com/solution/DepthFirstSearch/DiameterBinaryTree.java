package com.solution.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

import com.solution.Utility.TreeNode;

public class DiameterBinaryTree {
    /*
     * 
     * Strategy
     * [1] Start traversing the tree from the root node.
     * [2] For each node, calculate the height of the left and right subtree.
     * [3] For each node, update the diameter using the following formula:
     * max(diameter, left height + right height).
     * [4] After traversing the whole tree, return the diameter value since it is
     * the length of the tree’s diameter.
     */

    private List<Integer> diameterHelper(TreeNode<Integer> node, int diameter) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            result.add(0);
            result.add(diameter);
            return result;
        }

        // Compute the height of each subtree
        List<Integer> leftHeight = diameterHelper(node.getLeft(), diameter);
        diameter = leftHeight.get(1);

        List<Integer> rightHeight = diameterHelper(node.getRight(), diameter);
        diameter = rightHeight.get(1);

        // update the result with the max of the previous and current diameter
        // value
        diameter = Math.max(diameter, leftHeight.get(0) + rightHeight.get(0));

        // Use the larger one
        result.add(Math.max(leftHeight.get(0), rightHeight.get(0)) + 1);
        result.add(diameter);
        return result;
    }

    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        List<Integer> diameterList;
        int diameter = 0;
        if (root == null) {
            return 0;
        }

        diameterList = diameterHelper(root, diameter);
        return diameterList.get(1);
    }

}
