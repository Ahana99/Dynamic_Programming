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
     int[] v = {1,5,8,9,10,17,17,20}; // Values of the items
    int n = 8;
       int[] dp = new int[n+1];
       Arrays.fill(dp, -1);
        // Call the knapsack function and print the result
         int result = rodSplits(v,n,dp);
         System.out.println("Maximum value that can be obtained: " + result);
  }
  public static int rodSplits(int[] v, int n, int[] dp){
      if(n==0){
        return 0;
      }
      if(dp[n]!=-1){
        return dp[n];
      }
      
      int maxAmt = Integer.MIN_VALUE;
      for(int i=1; i<=n; i++){
          int currentPrice = v[i-1] + rodSplits(v, n-i, dp);
          maxAmt = Math.max(maxAmt, currentPrice);
      }
      
      dp[n] = maxAmt;
      
      return dp[n];

  }
}