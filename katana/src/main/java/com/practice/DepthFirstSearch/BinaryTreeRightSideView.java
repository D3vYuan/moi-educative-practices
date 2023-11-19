package com.practice.DepthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.solution.Utility.TreeNode;

public class BinaryTreeRightSideView {
    /*
     * 
     * [Strategy]
     * 
     */

    static Queue<TreeNode<Integer>> currentQueue = new LinkedList<>();
    static Queue<TreeNode<Integer>> nextQueue = new LinkedList<>();

    public static List<Integer> rightSideView(TreeNode<Integer> root) {
        List<Integer> data = new ArrayList<>();
        currentQueue.add(root);

        while (!currentQueue.isEmpty()) {
            TreeNode<Integer> node = currentQueue.poll();

            if (node.getLeft() != null) {
                nextQueue.add(node.getLeft());
            }

            if (node.getRight() != null) {
                nextQueue.add(node.getRight());
            }

            if (currentQueue.isEmpty()) {
                data.add(node.getData());
                if (!nextQueue.isEmpty()) {
                    currentQueue = nextQueue; // Switch to child Node
                    nextQueue = new LinkedList<>();
                } else {
                    break; // No More Nodes to Traverse
                }
            }
        }

        return data;
    }
}
