class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int val : nums) {
            queue.add(val);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}