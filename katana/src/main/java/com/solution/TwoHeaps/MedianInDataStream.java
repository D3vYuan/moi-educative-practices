package com.solution.TwoHeaps;

import java.util.PriorityQueue;

public class MedianInDataStream {
    /**
     * 
     * Strategy
     * [1] Split up incoming numbers into two lists—small and large. Those that are
     * smaller than the current middle element are small, and those that are larger
     * than it are large.
     * [2] Maintain these lists as heaps so that the root of the small heap is the
     * largest element in it and the root of large heap is the smallest element in
     * it.
     * [3] If the size of the large heap is greater than the size of small heap or,
     * if size of small heap is greater than the size of the large heap + 1,
     * rebalance the heaps.
     * [4] If the number of elements is even, the median is the mean of the root of
     * the two heaps. Else, it’s the root of the small heap.
     */

    PriorityQueue<Integer> maxHeapForSmallNumbers; // first-half
    PriorityQueue<Integer> minHeapForLargeNumbers; // second-half

    public MedianInDataStream() {
        maxHeapForSmallNumbers = new PriorityQueue<>((a, b) -> b - a);
        minHeapForLargeNumbers = new PriorityQueue<>((a, b) -> a - b);
    }

    public void insertNum(int num) {
        if (maxHeapForSmallNumbers.isEmpty() || maxHeapForSmallNumbers.peek() >= num) {
            maxHeapForSmallNumbers.add(num);
        } else {
            minHeapForLargeNumbers.add(num);
        }

        // either both the heaps will have equal number of elements or max-heap will
        // have one more element than the min-heap
        if (maxHeapForSmallNumbers.size() > minHeapForLargeNumbers.size() + 1) {
            minHeapForLargeNumbers.add(maxHeapForSmallNumbers.poll());
        } else if (maxHeapForSmallNumbers.size() < minHeapForLargeNumbers.size()) {
            maxHeapForSmallNumbers.add(minHeapForLargeNumbers.poll());
        }
    }

    public double findMedian() {
        if (maxHeapForSmallNumbers.size() == minHeapForLargeNumbers.size()) {
            // we have even number of elements, take the average of middle two elements
            return maxHeapForSmallNumbers.peek() / 2.0 + minHeapForLargeNumbers.peek() / 2.0;
        }

        // because max-heap will have one more element than the min-heap
        return maxHeapForSmallNumbers.peek();
    }
}
