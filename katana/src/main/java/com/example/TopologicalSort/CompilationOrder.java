package com.example.TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;



public class CompilationOrder {
    /**
     * There are a total of n classes labeled with the English alphabet (A, B, C, and so on). 
     * Some classes are dependent on other classes for compilation. For example, if class B extends class A, 
     * then B has a dependency on A. 
     * Therefore, A must be compiled before B.
     * 
     * Given a list of the dependency pairs, find the order in which the classes should be compiled.
     * 
     * Strategy
     * [1] Build the graph from the input using adjacency lists.
     * [2] Store the in-degree of each vertex in a hash map.
     * [3] Add the sources to a queue.
     * [4] Pop from the queue and store the node in a list, let’s call it sorted order.
     * [5] Decrement the in-degrees of the node’s children by 1. If the in-degree of a node becomes 0, add it to the source queue.
     * [6] Repeat until all vertices have been visited. Return the sorted order list.
     */

     public CompilationOrder(){

     }

     public List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies) {
        List<Character> sortedOrder = new ArrayList<>();

        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < dependencies.size(); i++) {
            
            char parent = dependencies.get(i).get(1);
            char child = dependencies.get(i).get(0);

            System.out.println("Populating graph...(" + child + "," + parent + ")");

            graph.computeIfAbsent(parent, k -> new ArrayList<>());
            graph.computeIfAbsent(child, k -> new ArrayList<>());
            
            inDegree.computeIfAbsent(parent, k -> 0);
            inDegree.computeIfAbsent(child, k -> 0);

            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        if (graph.size() <= 0){
            return sortedOrder;
        }

        Queue<Character> queue = new LinkedList<>();
        for (char key : inDegree.keySet()){
            System.out.println("Populating queue..." + key);
            if (inDegree.get(key) == 0) {
                queue.add(key);
            }
        }

        while (!queue.isEmpty()){
            char parent = queue.poll();
            sortedOrder.add(parent);

            System.out.println("Applying toplogical sort..." + parent);

            List<Character> children = graph.get(parent); 
            children.stream().forEach(child -> {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    queue.add(child);
                }
            });
        }

        if (sortedOrder.size() != graph.size()){
            return new ArrayList<>();
        }
        return sortedOrder;
    }
}
