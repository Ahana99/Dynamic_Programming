/**
 * You are given two integers N and K. N represents the number of eggs and K represents the number of floors in a building.
 * You have to find the minimum number of attempts you need in order to find the critical floor in the worst case while using the best strategy.
 * The critical floor is defined as the lowest floor from which you drop an egg and it doesn't break. 
 * There are certain which you have to follow -
   a. All eggs are identical.
   b. An egg that survives a fall can be used again.
   c. A broken egg can't be used again.
   d. If the egg doesn't break at a certain floor, it will not break at any floor below.
   e. If the egg breaks at a certain floor, it will break at any floor above.

   * Now suppose there is riskfactor associated with each floor and an array of the risk factors are provided
 */

import java.util.Arrays;

public class MyClass {

    public static int eggDrop(int k, int n, int[][] dp) {
        if(n == 0 || n == 1){
            return 0;
        }
        if(k == 1){
            return n;
        }
        if(dp[k][n] != 0){
            return dp[k][n];
        }
        int minAttempts = Integer.MAX_VALUE;
        int low = 1, high = n;
        while(low<=high){
            int mid = low +(high - low) /2;
            
            int breakCase = eggDrop(k-1, mid-1, dp);
            int noBreakCase = eggDrop(k, n-mid, dp);
            int attempts = Math.max(breakCase, noBreakCase) + 1;
            
            minAttempts = Math.min(minAttempts, attempts);
            if(breakCase>noBreakCase){
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }
        
        dp[k][n] = minAttempts;
        
        return dp[k][n];
        
    }

    public static void main(String[] args) {
        int eggs = 4;
        int floors = 5;
        int[] riskFactors = {1, 2, 5, 1, 2};
        int riskFloors = riskFactors.length;
        int[] dp = new int[riskFloors+1];
        Arrays.fill(dp,-1);
        
        System.out.println("Minimum number of attempts: " + eggDrop(eggs, floors, new int[eggs+1][floors+1]));
        System.out.println("Minimum number of attempts: " + eggDropRisked(eggs, riskFloors, riskFactors, dp));
    }
    
    public static int eggDropRisked(int n, int k, int[] risk, int[] dp){
        if(n==0){
            return Integer.MAX_VALUE;
        }
        if(n==1){
            return k;
        }
        if(k==1){
            return 1;
        }
        if(dp[k]!=-1){
            return dp[k];
        }
        
        int minAttempts = Integer.MAX_VALUE;
        int low = 1, high = k;
        while(low<=high){
            int mid = low + (high - low) / 2;
            int riskFactor = risk[mid-1];
            
            int breaks = eggDropRisked(n-1, mid-1, risk, dp);
            int noBreaks = eggDropRisked(n, k-mid, risk, dp);
            int attempts = Math.max(breaks, noBreaks) + 1;
            
            minAttempts = Math.min(minAttempts, attempts+riskFactor);
            if(breaks>noBreaks){
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }
        
        dp[k] = minAttempts;
        
        return dp[k];
        }