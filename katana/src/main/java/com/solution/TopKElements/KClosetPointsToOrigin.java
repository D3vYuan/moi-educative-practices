package com.solution.TopKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.solution.Utility.Point;

public class KClosetPointsToOrigin {

    /**
     * 
     * Strategy
     * [1] Push the first k points to the heap.
     * [2] Calculate the distance between the origin and each point.
     * [3] Compare the distance of the point with the distance of the top of the
     * heap.
     * [4] Push and pop the point from the heap.
     * [5] Return the points from the heap.
     */

    public static List<Point> kClosest(Point[] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a, b) -> b.distFromOrigin() - a.distFromOrigin());

        // put first 'k' points in the max heap
        for (int i = 0; i < k; i++) {
            maxHeap.add(points[i]);
        }

        // go through the remaining points of the input array, if a Location is closer
        // to the origin than the top Location
        // of the max-heap, remove the top Location from heap and add the Location from
        // the input array
        for (int i = k; i < points.length; i++) {
            if (points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()) {
                maxHeap.poll();
                maxHeap.add(points[i]);
            }
        }

        // the heap has 'k' points closest to the origin, return them in a list
        return new ArrayList<>(maxHeap);
    }
}
