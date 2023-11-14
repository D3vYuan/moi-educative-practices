package com.solution.Utility;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapsUtil {
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    public static void runHeap() {
        maxHeap.clear();
        int[] items = new int[] { 1, 3, 2, 5 };
        Arrays.stream(items).forEach(item -> maxHeap.offer(item));
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }

    public static void main(String[] args) {
        runHeap();
    }
}
