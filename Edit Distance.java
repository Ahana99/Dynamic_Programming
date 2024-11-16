/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
    * Insert a character
    * Delete a character
    * Replace a character
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return editDist(word1, word2, m, n, dp);
    }
    public int editDist(String w1, String w2, int i, int j, int[][]dp){
        if(i==0){
            return j;
        }
        if(j==0){
            return i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(w1.charAt(i-1) == w2.charAt(j-1)){
            dp[i][j]= editDist(w1, w2, i-1, j-1, dp);
        }else{
            int insert = editDist(w1, w2, i, j-1, dp);
            int delete = editDist(w1, w2, i-1, j, dp);
            int replace = editDist(w1,w2,i-1,j-1, dp);
            dp[i][j]= 1+Math.min(replace, Math.min(insert,delete));

        }

        return dp[i][j];
    }
}