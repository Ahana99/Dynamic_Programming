/**
 * You are given a number n, representing the count of items.
 * You are given n numbers, representing the values of n items.
 * You are given m numbers, representing the weights of n items.
 * You are given a number "cap", which is the capacity of a bag you've.
 * You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
 * NOTE: Each weight can be taken any number of times.
 */
import java.util.*;

public class UnboundedKnapsack {

    // Function to find the maximum value that can be obtained in the knapsack
    public static int unboundedKnapsack(int W, int[] wt, int[] val, int n) {
        int[] dp = new int[W + 1];  // dp[i] will store the max value for weight i
        
        // Process each capacity from 0 to W
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j < n; j++) {
                if (wt[j] <= i) {  // If the weight of the item is less than or equal to the current capacity
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        
        return dp[W];  // Maximum value that can be achieved with capacity W
    }

    public static void main(String[] args) {
        // Sample inputs
        int[] wt = {1, 3, 4, 5};  // Weights of the items
        int[] val = {1, 4, 5, 7};  // Values of the items
        int W = 7;  // Maximum weight of the knapsack
        int n = wt.length;  // Number of items

        // Call the function
        System.out.println("Maximum value in Knapsack: " + unboundedKnapsack(W, wt, val, n));
    }
}
