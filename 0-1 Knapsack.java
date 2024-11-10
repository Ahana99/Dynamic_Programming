/**
 * You are given a number n, representing the count of items.
 * You are given n numbers, representing the values of n items.
 * You are given m numbers, representing the weights of n items.
 * You are given a number "cap", which is the capacity of a bag you've.
 * You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
 */

import java.util.*;
public class MyClass {
  public static void main(String args[]) {
     int[] v = {15, 14, 10, 45, 30}; // Values of the items
        int[] w = {2, 5, 1, 3, 4}; // Weights of the items
        int capacity = 7; // Knapsack capacity
        int n = v.length; // Number of items
        
        // Memoization table, initialized with -1
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i],-1);
        }
        
        // Call the knapsack function and print the result
         int result = knapsack(v, w, capacity, n, dp);
         System.out.println("Maximum value that can be obtained: " + result);
  }
  public static int knapsack(int[] v, int[] w, int cap, int n, int[][] dp){
      if(n==0 || cap == 0){
          return 0;
      }
      if(dp[n][cap]!=-1){
          return dp[n][cap];
      }
      
      if(w[n-1]>cap){
          dp[n][cap] = knapsack(v, w, cap, n-1, dp);
      }
      else{
          int exclude = knapsack(v, w, cap, n-1, dp);
          int include = knapsack(v, w, cap-w[n-1], n-1, dp) + v[n-1];
          dp[n][cap] = Math.max(include, exclude);
      }
      return dp[n][cap];
  }
}