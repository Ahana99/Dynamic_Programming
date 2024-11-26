/**
 * here is a multi-core CPU.
 * A single-core in this CPU can execute only a single task at a given time, so if two tasks need to be executed simultaneously, we will need at least two different cores to process them.
 * You have been given a list of ‘N’ tasks that need to be executed, this list contains starting and ending times of each task.
 * Find out the minimum number of cores required in this CPU so that all the tasks can be executed at their scheduled time.
 */

import java.util.*;
public class Solution 
{
    public static int cpuTaskScheduler(int n, int[][] arr)
    {
         // Sort the tasks based on start time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // Min-Heap to store the end times of tasks currently being executed
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate through the tasks
        for (int[] task : arr) {
            int startTime = task[0];
            int endTime = task[1];

            // If the current task starts after the earliest ending task, reuse the core
            if (!minHeap.isEmpty() && minHeap.peek() <= startTime) {
                minHeap.poll(); // Remove the finished task
            }

            // Allocate a new core (add the current task's end time)
            minHeap.offer(endTime);
        }

        // The size of the heap represents the minimum number of cores required
        return minHeap.size();
	}
}