/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
 * The robot can only move either down or right at any point in time.
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
         if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        return obsCount(obstacleGrid, 0, 0, dp);
    }
    public int obsCount(int[][] grid, int row, int col, int[][] dp){
        if(row>=grid.length || col>=grid[0].length){
            return 0;
        }
        if (grid[row][col] == 1) {
        return 0;
    }
        if(row==grid.length-1 && col==grid[0].length-1){
            return 1;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        
        int right = obsCount(grid,row,col+1,dp);
        int down = obsCount(grid,row+1,col,dp);
        dp[row][col] = down+right;

        return dp[row][col];
    }
}