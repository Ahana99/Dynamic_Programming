/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 * For each step, you may move to an adjacent number of the row below.
 * More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 */

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][triangle.size()];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return tria(triangle, 0, 0, memo);
    }
    public int tria(List<List<Integer>> triangle, int row, int col, int[][] dp){
        if(row == triangle.size()-1) return triangle.get(row).get(col);
        if(dp[row][col]!=Integer.MAX_VALUE) return dp[row][col];

        int down = tria(triangle, row+1, col, dp); 
        int downright = tria(triangle, row+1, col+1, dp);
        int minCost = triangle.get(row).get(col) + Math.min(down,downright);
        dp[row][col]=minCost;

        return dp[row][col];

    }
}