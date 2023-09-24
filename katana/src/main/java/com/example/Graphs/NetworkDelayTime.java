package com.example.Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

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

     public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjacencyDictionary = new HashMap<>();
        for (int[] time : times){
            int source = time[0];
            int destination = time[1];
            int travelTime = time[2];
            if (!adjacencyDictionary.containsKey(source)){
                adjacencyDictionary.putIfAbsent(source, new ArrayList());
            }
            List<int[]> adjacency_list = adjacencyDictionary.get(source);
            adjacency_list.add(new int[]{ destination, travelTime});
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        priorityQueue.offer(new int[]{0, k}); //first node
        
        Set<Integer> visited = new HashSet<>();
        int delays = 0;

        while (!priorityQueue.isEmpty()){
            int[] currentNode = priorityQueue.poll();
            int time = currentNode[0];
            int nodeIndex = currentNode[1];

            if (visited.contains(nodeIndex)){
                continue;
            }

            visited.add(nodeIndex);
            delays = Math.max(delays, time);
            List<int[]> neighbors = adjacencyDictionary.getOrDefault(nodeIndex, new ArrayList<>());

            for (int[] neighbor : neighbors){
                int neighborNodeIndex = neighbor[0];
                int neighborTime = neighbor[1];

                if (!visited.contains(neighborNodeIndex)){
                    int newTime = time + neighborTime;
                    priorityQueue.offer(new int[] { newTime, neighborNodeIndex });
                }
            }
        }

        if (visited.size() == n){
            return delays;
        }

        // Replace this placeholder return statement with your code    
        return -1;
    }
}
