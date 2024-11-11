/**
 * You are given an integer N, which represents the length of a rod, and an array of integers, which represents the prices of rod pieces of length varying from 1 to N.
 * You have to find the maximum value that can be obtained by selling the rod.
 * You can sell it in pieces or as a whole.
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