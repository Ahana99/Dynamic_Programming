/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;
        int[][] dp = new int[row][col];
        int maxDim=0;

        for(int i = 0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(matrix[i][j] == '1'){
                    maxDim = Math.max(maxDim, maxSquare(matrix, i, j, dp));
                }
            }
        }
        return (maxDim*maxDim);
    }
    public int maxSquare(char[][] m, int i, int j, int[][] dp){
        if(i<0 || j<0 || m[i][j] == '0') return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int top= maxSquare(m,i-1, j, dp);
        int left= maxSquare(m, i, j-1, dp);
        int diagonalTop= maxSquare(m, i-1, j-1, dp);

        dp[i][j] = Math.min(Math.min(top,left), diagonalTop) + 1;

        return dp[i][j];
    }
}