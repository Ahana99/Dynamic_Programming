/**
 * 1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
 * The road is to be so planned that there should not be consecutive buildings on either side of the road.
 * You are required to find and print the number of ways in which the buildings can be built on both side of roads.
 */

import java.util.*;
import java.math.*;
public class MyClass {
  public static void main(String args[]) {
     int n = 70;
     
     BigInteger result = arrange(n, new BigInteger[n+1]).pow(2);
     System.out.println("Maximum value that can be obtained: " + result);
  }
  
  public static BigInteger arrange(int n, BigInteger[] dp){
      
      if(n==0){
          return BigInteger.ZERO;
      }
      if(n==1){
          return BigInteger.valueOf(2);
      }
      if(n==2){
          return BigInteger.valueOf(3);
      }
      if(dp[n]!=null){
          return dp[n];
      }
      
      BigInteger maxAmt = arrange(n-1, dp).add(arrange(n-2, dp));
      dp[n] = maxAmt;
      
      return dp[n];
  }
}
