/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 */

class Solution {
    int m, n, N;
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        m=s1.length();
        n=s2.length();
        N=s3.length();
        dp = new Boolean[m+1][n+1];

        if(N!=n+m) return false;

        return checkInterleave(0, 0, 0, s1, s2, s3);
    }
    public boolean checkInterleave(int i, int j, int k, String s1, String s2, String s3){
        if(i==m && j==n && k==N) return true;
        if(dp[i][j]!=null) return dp[i][j]; 

        boolean result = false;

        if(i<m && s1.charAt(i)==s3.charAt(k)){
            result = checkInterleave(i+1, j, k+1, s1, s2, s3);
        }
        if(result){
            dp[i][j]=result;
            return result;
        }
        if(j<n && s2.charAt(j)==s3.charAt(k)){
            result = checkInterleave(i, j+1, k+1, s1, s2, s3);
        }
        dp[i][j]=result;
        return dp[i][j];
    }
}