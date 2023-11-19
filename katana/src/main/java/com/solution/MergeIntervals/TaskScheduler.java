package com.solution.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskScheduler {
    /*
     * 
     * Strategy
     * [1] Count and store the frequencies of all the tasks.
     * [2] Sort the frequencies.
     * [3] Start scheduling the tasks in the descending order of their frequencies,
     * and compute the idle time during the process.
     * [4] The total time can be calculated as the sum of the number of tasks and
     * the idle time.
     */

    public static int leastTime(char[] tasks, int n) {
        // Initialize a HashMap to store the frequencies of the tasks
        Map<Character, Integer> frequencies = new HashMap<>();

        // Store the frequency of each task
        for (char item : tasks) {
            frequencies.put(item, frequencies.getOrDefault(item, 0) + 1);
        }

        // Sort Frequencies
        List<Map.Entry<Character, Integer>> sortedFrequencies = new ArrayList<>(frequencies.entrySet());
        Collections.sort(sortedFrequencies, (a, b) -> a.getValue().compareTo(b.getValue()));

        // Store the max frequency
        int maxFreq = sortedFrequencies.get(sortedFrequencies.size() - 1).getValue();
        sortedFrequencies.remove(sortedFrequencies.size() - 1);

        // Compute maximum possible idle time
        int idleTime = (maxFreq - 1) * n;

        // Iterate over the frequencies array and update the idle time
        while (!sortedFrequencies.isEmpty() && idleTime > 0) {
            int currentFrequencies = sortedFrequencies.get(sortedFrequencies.size() - 1).getValue();
            idleTime -= Math.min(maxFreq - 1, currentFrequencies);
            sortedFrequencies.remove(sortedFrequencies.size() - 1);
        }
        idleTime = Math.max(0, idleTime);

        return tasks.length + idleTime;
    }

}
