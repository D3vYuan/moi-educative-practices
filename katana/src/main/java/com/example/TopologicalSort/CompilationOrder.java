package com.example.TopologicalSort;

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
}
