/**
 * You are given a number n.
 * You are required to print the number of binary strings of length n with no consecutive 0's.
 */

import java.util.*;
public class MyClass {
  public static void main(String args[]) {
     int n = 6;
     
     int result = countBinary(n, new int[n+1]);
     System.out.println("Maximum value that can be obtained: " + result);
  }
  
  public static int countBinary(int n, int[] dp){
      
      if(n==0){
          return 0;
      }
      if(n==1){
          return 2;
      }
      if(n==2){
          return 3;
      }
      if(dp[n]!=0){
          return dp[n];
      }
      
      int maxAmt = countBinary(n-1, dp) + countBinary(n-2, dp);
      dp[n] = maxAmt;
      
      return maxAmt;
  }
}