package com.solution.TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
    /**
     * 
     * Strategy
     * [1] Initialize a graph containing the key as the parent and the value as its
     * child’s vertices.
     * [2] Populate the in-degrees hash map.
     * [3] Find all sources with 0 in-degrees.
     * [4] For each source, append it to a sorted list, retrieve all of its
     * children, and decrement the in-degrees of the respective child by 1.
     * [5] Repeat the process until the source queue becomes empty.
     */

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int counter = 0;
        if (numCourses <= 0) {
            return false;
        }

        // Initialize the graph
        // count of incoming prerequisites
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        // b. Build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];
            graph.get(parent).add(child); // put the child into it's parent's list
            inDegree.put(child, inDegree.get(child) + 1);
        }

        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        // d. For each source, increment the counter and subtract one from
        // all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            counter++;
            // get the node's children to decrement their in-degrees
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        return counter == numCourses;
    }
}
