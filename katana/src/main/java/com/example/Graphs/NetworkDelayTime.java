package com.example.Graphs;

public class NetworkDelayTime {
    /**
     * A network of n nodes labeled 1 to n is provided along with a list of travel times for directed edges represented as 
     * times[i]=(xi, yi, ti), where xi is the source node, yi is the target node, and ti is the delay time from the source node to the target node.
     * 
     * Considering we have a starting node, k, we have to determine the minimum time required for all the remaining 
     * n−1 nodes to receive the signal. Return −1 if it’s not possible for all n−1 nodes to receive the signal.
     * 
     * Strategy
     * [1] Create an adjacency dictionary to store the information of the nodes and their edges.
     * [2] Create a visited set to track the nodes that have already been processed and a priority queue to store the nodes and their delay times.
     * [3] Process the nodes from the priority queue by first visiting the node with the smallest delay time and updating the delay time if necessary.
     * [4] Add the unvisited neighbors of the processed node to the priority queue with their new delay times.
     * [5] Return the delay time if all nodes have been processed. Otherwise, return −1.
     */

     public NetworkDelayTime(){

     }
}
