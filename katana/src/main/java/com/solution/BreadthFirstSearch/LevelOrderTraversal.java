package com.solution.BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrderTraversal {
    /**
     * Given the root of a binary tree, display the values of its nodes while
     * performing a level order traversal. Return the node values for all levels in
     * a string separated by the character :.
     * If the tree is empty, i.e., the number of nodes is 0, then return “None” as
     * the output.
     * 
     * Strategy
     * [1] Declare two queues, currentQueue and nextQueue.
     * [2] Push the root node to currentQueue and set the level to zero.
     * [3] Dequeue the first element from currentQueue and push its children in
     * nextQueue.
     * [4] If currentQueue is empty, increase the level number and swap the two
     * queues.
     * [5] Repeat until currentQueue is empty.
     */

    class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public LevelOrderTraversal() {

    }

    public String levelOrderTraversal(TreeNode<Integer> root) {
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return "None";
        }

        ArrayList<Queue<TreeNode<Integer>>> queues = new ArrayList<>();
        queues.add(new ArrayDeque<TreeNode<Integer>>());
        queues.add(new ArrayDeque<TreeNode<Integer>>());

        Queue<TreeNode<Integer>> currentQueue = queues.get(0);
        Queue<TreeNode<Integer>> nextQueue = queues.get(1);

        currentQueue.add(root);
        int levelNumber = 0;
        int n = 0;

        while (!currentQueue.isEmpty()) {
            n += 1;

            TreeNode<Integer> temp = currentQueue.poll();
            result.append(String.valueOf(temp.data));

            if (temp.left != null) {
                nextQueue.add(temp.left);
            }

            if (temp.right != null) {
                nextQueue.add(temp.right);
            }

            if (currentQueue.isEmpty()) {
                ++levelNumber;
                if (!nextQueue.isEmpty()) {
                    result = result.append(" : ");
                }
                currentQueue = queues.get(levelNumber % 2);
                nextQueue = queues.get((levelNumber + 1) % 2);
            } else {
                result = result.append(", ");
            }

        }

        // Replace this placeholder return statement with your code
        return result.toString();
    }
}
