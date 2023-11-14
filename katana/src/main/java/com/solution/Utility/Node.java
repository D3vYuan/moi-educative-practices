package com.solution.Utility;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int data;
    List<Node> neighbors;

    public Node(int data) {
        this.data = data;
        this.neighbors = new ArrayList<Node>();
    }

    public int getData() {
        return this.data;
    }

    public List<Node> getNeighbors() {
        return this.neighbors;
    }
}
