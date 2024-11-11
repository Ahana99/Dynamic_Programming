/**
 * You are given an integer N, which represents the length of a rod, and an array of integers, which represents the prices of rod pieces of length varying from 1 to N.
 * You have to find the maximum value that can be obtained by selling the rod.
 * You can sell it in pieces or as a whole.
 */

import java.util.*;
public class MyClass {
  public static void main(String args[]) {
     int[] v = {15, 14, 10, 45, 30}; // Values of the items
    int n = 5;
       
        // Call the knapsack function and print the result
         int result = rodSplits(v,n,new int[v.length+1]);
         System.out.println("Maximum value that can be obtained: " + result);
  }
  public static int rodSplits(int[] v, int n, int[] dp){
      if(n==0){
        return 0;
      }
      if(dp[n]!=0){
        return dp[n];
      }
  }
}