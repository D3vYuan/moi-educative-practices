package com.solution.DepthFirstSearch;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import com.solution.Utility.TreeNode;

public class MaximumDepthTree {
    /**
     * 
     * Strategy
     * [1] Initialize a counter to track the maximum depth seen so far and a stack
     * for the depth of the current branch.
     * [2] If the current node is NULL, return the counter.
     * [3] Otherwise, check the depth of the left subtree and the depth of the right
     * subtree.
     * [4] If the depth of the current branch exceeds the maximum depth seen so far,
     * update the maximum depth.
     * [5] When all branches have been explored, return the maximum depth seen so
     * far.
     * 
     */

    public static int findMaxDepth(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode<Integer>> stack = new ArrayDeque<>();
        Queue<Integer> deptQueue = new LinkedList<>();

        stack.offer(root);
        deptQueue.offer(1);

        int maxDepth = 0;

        while (!stack.isEmpty()) {
            TreeNode<Integer> node = stack.poll();
            int depth = deptQueue.poll();

            if (node.getLeft() != null) {
                stack.offer(node.getLeft());
                deptQueue.offer(depth + 1);
            }

            if (node.getRight() != null) {
                stack.offer(node.getRight());
                deptQueue.offer(depth + 1);
            }

            if (node.getLeft() == null && node.getRight() == null) {
                maxDepth = Math.max(maxDepth, depth);
            }
        }

        return maxDepth;
    }
}
