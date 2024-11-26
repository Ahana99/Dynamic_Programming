/**
 * You are given a tree consisting of ‘N’ nodes. Your task is to find the level of the tree with the maximum sum.
 * The level of a node of the tree is the distance of the node from the root node + 1.
 */

import java.util.LinkedList;
import java.util.Queue;

/* ***************************************
    Following is the TreeNode class structure:
    
    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = right = null;
        }

    };

*****************************************/
public class Solution {

	public static int maxLevelSum(TreeNode<Integer> root) {
		 if (root == null) return 0;

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        int maxSum = Integer.MIN_VALUE;  // Initialize maxSum to the smallest possible value
        q.add(root);
        int maxSumLevel = 1;
        int level = 1;
        // Perform level-order traversal using the queue
        while (!q.isEmpty()) {
            int levelSum = 0; // Sum of the current level
            int numberOfNodes = q.size(); // Number of nodes at the current level
            
            // Traverse all nodes at the current level
            for (int i = 0; i < numberOfNodes; i++) {
                TreeNode<Integer> curr = q.poll(); // Dequeue the current node
                levelSum += curr.data; // Add the node's value to the level sum
                
                // Add left and right children to the queue for next level
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            
            if(levelSum>maxSum){
                maxSum = levelSum;
                maxSumLevel = level;
            }
            level++;
        }

        return maxSumLevel; // Return the maximum level sum

	}

}
