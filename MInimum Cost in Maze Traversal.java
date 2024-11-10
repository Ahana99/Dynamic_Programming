/**
    * You are given n: no. of rows and m: no. of columns
    * You are given n*m numbers representing the cell cost in the maze
    * You are standing at the top-left cell and are required to move to the bottom-right cell
    * For each cell, you have to pay a cost represented by the cell value
    * Your are to find the minimum cost that can be paid to traverse
*/

public class MyClass {
  static int minCost(int n, int m, int[][] arr, int[][] dp) {
     if(n>=arr.length || m>=arr[0].length || arr[n][m]<0){
	    return Integer.MAX_VALUE;
	}
	if(n==arr.length-1 && m==arr[0].length-1){
	    return arr[n][m];
	}
	if(dp[n][m]!=0){
	    return dp[n][m];
	}
	int minVal = arr[n][m];
	
	int rightCost= minCost(n, m+1, arr, dp);
	int downCost= minCost(n+1, m, arr, dp);
	
	minVal+= Math.min(rightCost, downCost);
	dp[n][m]=minVal;
	
	return dp[n][m];
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
       int[][] x = {
    { 12, 57, 89 },
    { 34, 37, 25 },
    { 10, 46, 68 }};
         System.out.println(minCost(0, 0, x, new int[n][m]));
    }
}