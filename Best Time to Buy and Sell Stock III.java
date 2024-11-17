/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp = new int[n][3][2];
        for (int k = 0; k <= 2; k++) {
            dp[0][k][0] = 0;               // No stock, no profit
            dp[0][k][1] = -prices[0];      // Holding stock after buying on day 0
        }
        
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= 2; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]); // Max of no action or selling stock
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]); // Max of no action or buying stock
            }
        }

        // Maximum profit at the last day with at most 2 transactions and no stock
        return dp[n - 1][2][0];
    }
}