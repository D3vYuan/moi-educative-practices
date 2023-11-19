package com.solution.DepthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.solution.Utility.TreeNode;

public class BinaryTreeRightSideView {
    /*
     * 
     * Strategy
     * [1] Return an empty list if the root is NULL.
     * [2] Initialize a list to store the result. Apply depth-first search starting
     * from the root.
     * [3] At each visited node, if the length of the list is equal to the current
     * tree level, then add the data of the node to the list.
     * [4] Iterate over the child nodes of the current node (first the right child,
     * then the left child). For each child, call DFS recursively.
     * [5] After the DFS is completed, return the list.
     */

    // Function to get the right side view of a binary tree
    private static void dfs(TreeNode<Integer> node, int level, List<Integer> rside) {
        if (level == rside.size()) {
            rside.add(node.getData());
        }

        List<TreeNode<Integer>> children = new ArrayList<>();
        children.add(node.getRight());
        children.add(node.getLeft());

        for (TreeNode<Integer> child : children) {
            if (child != null) {
                dfs(child, level + 1, rside);
            }
        }
    }

    public static List<Integer> rightSideView(TreeNode<Integer> root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> rside = new ArrayList<>();
        dfs(root, 0, rside);

        return rside;
    }
}
