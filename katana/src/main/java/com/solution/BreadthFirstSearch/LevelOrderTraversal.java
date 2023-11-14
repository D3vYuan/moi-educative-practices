package com.solution.BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.solution.Utility.TreeNode;

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

    public static String levelOrderTraversal(TreeNode<Integer> root) {
        if (root == null) {
            return "None";
        }

        StringBuilder sb = new StringBuilder();
        List<Queue<TreeNode<Integer>>> queues = new ArrayList<>();

        queues.add(new LinkedList<TreeNode<Integer>>());
        queues.add(new LinkedList<TreeNode<Integer>>());

        Queue<TreeNode<Integer>> currentQueue = queues.get(0);
        Queue<TreeNode<Integer>> nextQueue = queues.get(1);

        currentQueue.add(root);

        int levelNumber = 0;
        int n = 0;

        while (!currentQueue.isEmpty()) {
            n += 1;

            TreeNode<Integer> currentNode = currentQueue.poll();
            sb.append(String.valueOf(currentNode.getData()));

            if (currentNode.getLeft() != null) {
                nextQueue.add(currentNode.getLeft());
            }

            if (currentNode.getRight() != null) {
                nextQueue.add(currentNode.getRight());
            }

            if (currentQueue.isEmpty()) {
                levelNumber += 1;
                if (!nextQueue.isEmpty()) {
                    sb.append(" : ");
                }
                // Switch Next Queue with Current Queue
                currentQueue = queues.get(levelNumber % 2);
                nextQueue = queues.get((levelNumber + 1) % 2);
            } else {
                sb.append(",");
            }
        }

        return sb.toString();
    }
}
