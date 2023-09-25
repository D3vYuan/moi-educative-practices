package com.example.Greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumRefuelingStops {
    /**
     * 
     * 
     * Strategy
     * [1] If the start fuel is greater than or equal to the target, then the car doesn’t need to refuel, so return 0
     * [2] Iterate over the refueling stations until the maximum distance is less than the target and the car is not out of fuel.
     * [3] If the car can reach the next station from the current position, then add its fuel capacity to the max-heap.
     * [4] If the car cannot reach the next fuel station, pop the station with the highest fuel value from the max-heap, add its fuel to the car’s tank, and increment the stops.
     * [5] Return the number of stops. If the car cannot reach the destination even after stopping at all the fuel stations, return −1
     */
    
    public MinimumRefuelingStops(){

    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // If starting fuel is already greater or equal to target, no need to refuel
        if (startFuel >= target){
            return 0;
        }

        // Create a max heap to store the fuel capacities of stations in
        // such a way that maximum fuel capacity is at the top of the heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Initialize variables for loop
        int i = 0;
        int n = stations.length;
        int stops = 0;
        int maxDistance = startFuel;

        // Loop until the car reach the target or the car is out of fuel
        while (maxDistance < target){
            // If there are still stations and the next one is within range, add its fuel capacity to the max heap
            if (i < n && stations[i][0] <= maxDistance){
                maxHeap.add(stations[i][1]);
                i++;
            } 
            // If there are no more stations and we can't reach the target, return -1
            else if (maxHeap.isEmpty()){
                return -1;
            } 
            // Otherwise, fill up at the station with the highest fuel capacity and increment stops
            else {
                maxDistance += maxHeap.poll();
                stops++;
            }
        }

        // Return the number of stops taken
        return stops;
    }
}
