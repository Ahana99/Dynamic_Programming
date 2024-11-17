/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp = new int[n][k+1][2];
        for(int i = 0;i<=k;i++){
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for(int i=1; i<n;i++){
            for(int j = 1; j<=k;j++){
                dp[i][j][0]= Math.max(dp[i-1][j][0], dp[i-1][j][1]+prices[i]);
                dp[i][j][1]= Math.max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i]);
            }
        }

        return dp[n-1][k][0];
    }
}