package com.example.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BusRoutes {
    /**
     * You are given an array, routes, representing bus routes where routes[i] is a
     * bus route that the ith bus repeats forever.
     * Every route contains one or more stations. You have also been given the
     * source station, src, and a destination station, dest.
     * Return the minimum number of buses someone must take to travel from src to
     * dest, or return -1 if there is no route.
     * 
     * Strategy
     * [1] Create an adjacency list that maps each station to the buses that travel
     * through that station.
     * [2] Initialize a queue with a source station and the bus count.
     * [3] Iterate the queue either till it is empty or the destination station has
     * arrived.
     * [4] Visit connecting stations of the dequeued station, and enqueue connecting
     * stations.
     * [5] In every iteration, increase the bus count if a new bus is passing
     * through the same station.
     * [6] Return the bus count.
     */

    public static int minimumBuses(int[][] busRoutes, int src, int dest) {
        // Create adjacency list for graph
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < busRoutes.length; i++) {
            for (int station : busRoutes[i]) {
                if (!adjList.containsKey(station)) {
                    adjList.put(station, new ArrayList<>());
                }
                adjList.get(station).add(i);
            }
        }

        // Create a queue with initial source and bus count of 0
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { src, 0 });

        // Create a set to contain visited routes of buses
        Set<Integer> visitedBus = new HashSet<>();

        // Iterate till the queue is empty
        while (!queue.isEmpty()) {
            // Pop station and and number of buses taken and store in variables.
            int[] current = queue.peek();
            int station = current[0];
            int busesTaken = current[1];
            queue.poll();

            // If we have reached the destination station, return number of buses taken.
            if (station == dest) {
                return busesTaken;
            }

            // If station is in graph, then iterate over the stations in graph
            // and if it is not already visited, enqueue all the stations in that bus
            // route along with an incremented bus count and mark the bus visited.
            if (adjList.containsKey(station)) {
                for (int bus : adjList.get(station)) {
                    if (!visitedBus.contains(bus)) {
                        for (int route : busRoutes[bus]) {
                            queue.add(new int[] {
                                    route, busesTaken + 1
                            });
                        }
                        visitedBus.add(bus);
                    }
                }
            }
        }

        // If the route is not found, return -1.
        return -1;
    }
}
