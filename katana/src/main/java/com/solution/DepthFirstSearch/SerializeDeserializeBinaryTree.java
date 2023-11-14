package com.solution.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

import com.solution.Utility.TreeNode;

public class SerializeDeserializeBinaryTree {
    /*
     * 
     * Strategy
     * [1] Perform a depth-first traversal and serialize individual nodes to the
     * stream.
     * [2] Also, serialize a marker to represent a NULL pointer that helps
     * deserialize the tree.
     * [3] Deserialize the tree using preorder traversal.
     * [4] During deserialization, create a new node for every non-marker node using
     * preorder traversal.
     */
    public static List<String> serialize(TreeNode<Integer> root) {

        // Replace this placeholder return statement with your code
        return new ArrayList<>();
    }

    public static TreeNode<Integer> deserialize(List<String> stream) {

        // Replace this placeholder return statement with your code
        return new TreeNode<Integer>(0);
    }
}
