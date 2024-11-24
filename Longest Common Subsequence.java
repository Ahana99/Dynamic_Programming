/**
 * Given two sequences (strings), X and Y, find the length of the longest subsequence (not necessarily contiguous) that is common to both sequences.
 * Example:
    * X = "ABCBDAB"
    * Y = "BDCAB"
 * The longest common subsequence is "BCAB", which has a length of 4.
 */

public class LongestCommonSubsequence {

    public static int lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        
        // Create a 2D DP array to store the lengths of longest common subsequences
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    // If characters match, take diagonal value + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If characters don't match, take the maximum of the value from the top or left
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // The value at dp[m][n] will be the length of the LCS
        return dp[m][n];
    }

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCAB";
        
        // Call the function and print the result
        System.out.println("Length of LCS: " + lcs(X, Y));
    }
}
