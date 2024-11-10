/**
 * You are given a number n, representing the count of items.
 * You are given n numbers, representing the values of n items.
 * You are given m numbers, representing the weights of n items.
 * You are given a number "cap", which is the capacity of a bag you've.
 * You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
 * NOTE: Each weight can be taken any number of times.
 */

import java.util.*;
public class MyClass {
  public static void main(String args[]) {
     int[] v = {15, 14, 10, 45, 30}; // Values of the items
        int[] w = {2, 5, 1, 3, 4}; // Weights of the items
        int capacity = 7; // Knapsack capacity
        int n = v.length; // Number of items
        
        // Memoization table, initialized with -1
        int[] dp = new int[capacity + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp,-1);
        }
        
        // Call the knapsack function and print the result
         int result = knapsack(v, w, capacity, dp);
         System.out.println("Maximum value that can be obtained: " + result);
  }
  public static int knapsack(int[] v, int[] w, int cap, int[] dp){
      
      if(cap<=0){
          return 0;
      }
      
      if(dp[cap]!=-1){
          return dp[cap];
      }
      
      int maxAmt=Integer.MIN_VALUE;
      
     for(int i = 0; i<w.length;i++){
         if(cap>=w[i]){
             int res = knapsack(v, w, cap-w[i], dp);
             if(res!=Integer.MIN_VALUE){
                 maxAmt = Math.max(maxAmt, res+v[i]);
             }
         }
     }
      dp[cap] = maxAmt;
      return dp[cap];
  }
}