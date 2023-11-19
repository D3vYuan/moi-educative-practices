package com.solution.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class MaximumProfitJobScheduling {
    /*
     * 
     * Strategy
     * [1] Combine the input data into a single array of tuples, jobs, where each
     * tuple contains the start time, end time, and associated profit of a job.
     * [2] Sort the jobs array based on the end times of jobs in ascending order.
     * [3] Iterate through the jobs array, and for each job, check whether it can be
     * included in the schedule while maintaining non-overlapping time ranges.
     * [4] Calculate the profit by including the current job, and by excluding the
     * current job. Then, select the maximum of the two as the optimal profit for
     * the current job.
     * [5] After iterating all the jobs and considering various scheduling options,
     * return the profit value against the schedule which yields the highest profit
     * as the final answer.
     * 
     * Explanation
     * [1] We use binary search to efficiently determine whether any of the
     * previously scheduled jobs overlap with the current job under consideration by
     * comparing the end time of the previously scheduled job with the
     * current job's start time.
     * [2] Combine all the information related to a particular job in a triplet,
     * such as (startTime[i], endTime[i], profit[i]),
     * and then store these triplets in a new array, jobs.
     * [3] Next, we sort the jobs array with respect to each job's end time in
     * ascending order. This is to minimize the chance of selecting jobs with
     * overlapping time ranges because now jobs with earlier end times will be
     * considered before jobs with later end times.
     * [4] Now, we create an array, dp, of size n to store the results of each
     * subproblem. Each element, dp[i], will store the maximum profit that can be
     * obtained by considering only the first i jobs.
     * [5] To fill up dp, we iterate through the sorted jobs in the jobs array. For
     * each job, jobs[i], we consider two options:
     * - Include the current job: Here, we count the current job's profit,
     * jobs[i][2], towards the calculation of the maximum profit, includedProfit.
     * * Add the current job's profit to the profit obtained from jobs that don't
     * overlap with the current job.
     * * We need to make sure that the previous job doesn't overlap with the current
     * one, we use binary search to find the index,
     * prevValidJob, of the latest possible job that doesn't overlap with the
     * current job's start time.
     * * If there is no such job, binary search returns −1.
     * * Once we have the required index, we can use the profit against it,
     * dp[prevValidJob], to calculate the value of the maximum profit,
     * includedProfit = jobs[i][2] + dp[prevValidJob].
     * - Exclude the current job: Ignore the current job's profit
     * towards the calculation of the maximum profit, excludedProfit. Just consider
     * the profit value in the previous cell, dp[i-1], which represents the maximum
     * profit that can be obtained up to the previous job, jobs[i-1].
     * [6] For the first job, when i = 0, we set includedProfit to its profit value
     * and excludedProfit to 0 since there is no other job in the comparison.
     * [7] Once we have calculated the values of includedProfit and excludedProfit,
     * we set dp[i] to the maximum value among the two. This is to choose the option
     * that yields the higher profit: including the current job or excluding it.
     * [8] After iterating through all jobs, the last element, dp[n-1], will contain
     * the final answer.
     */

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        // Create a new array to store the combined input data
        List<List<Integer>> jobs = new ArrayList<>();

        // Combine the input data into a single array of triplets
        for (int i = 0; i < n; i++) {
            List<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);
            jobs.add(currJob);
        }

        // Sort jobs by end times to optimize scheduling
        jobs.sort((a, b) -> a.get(1) - b.get(1));

        // Initialize dynamic programming array to store maximum profit
        List<Integer> dp = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            // Calculate profit if the current job is included
            int includedProfit = jobs.get(i).get(2);

            // Find the index of the last job that doesn't overlap with the current job
            int prevValidJob = binarySearch(jobs, i);

            // If there is a valid previous job, add its profit to the included profit
            if (prevValidJob != -1) {
                includedProfit += dp.get(prevValidJob);
            }

            // Calculate profit if the current job is excluded
            // For the first job, excluded profit is 0
            int excludedProfit = (i > 0) ? dp.get(i - 1) : 0;

            // Choose the maximum profit between including and excluding the current job
            dp.add(Math.max(includedProfit, excludedProfit));
        }

        return dp.get(n - 1);
    }

    public static int binarySearch(List<List<Integer>> jobs, int currentJob) {
        // Initialize the left and right pointers
        int left = 0;
        int right = currentJob - 1;

        // Initialize the index of the last valid job as -1
        int prevValidJob = -1;

        // Update the last valid job's index and narrow the search to the right
        while (left <= right) {
            int mid = (left + right) / 2;

            // Mid job end time is smaller than current job start time -
            if (jobs.get(mid).get(1) <= jobs.get(currentJob).get(0)) {
                prevValidJob = mid;
                left = mid + 1;
            } else {
                // Adjust the search range to the left
                right = mid - 1;
            }
        }

        return prevValidJob;
    }
}
