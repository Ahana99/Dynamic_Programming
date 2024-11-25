/**
 * 
 */

import java.util.*;

public class TopKFrequentElements {

    // Function to find the top K frequent elements in the list
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element using a HashMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a min-heap to keep track of the top K frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue() // Compare based on frequency
        );

        // Step 3: Add elements to the heap, ensuring the heap size is at most K
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }

        // Step 4: Extract the top K frequent elements from the heap
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        // Since the heap gives us the least frequent element first, reverse the result list
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3}; // Example input
        int k = 2; // Find the top 2 frequent elements

        List<Integer> result = topKFrequent(nums, k);
        System.out.println("Top " + k + " frequent elements: " + result);
    }
}
