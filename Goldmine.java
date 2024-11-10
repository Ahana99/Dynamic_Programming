/**
    * You are given n: no. of rows and m: no. of columns
    * You are given n*m numbers representing the cell cost or gold value at that cell in the goldmine
    * You are standing at the left wall and need to dig your way to the right wall
    * You can start at any row of the left wall
    * You are only allowed to dig up, down or right by 1 cell only but you cannot stay in the same column once you start digging
    * So if you are at arr[i][j], you can move to arr[i][j] (immediate right), arr[i-1][j+1] (immediate up in the next column) and arr[i+1][j+1] (immediate down in the next column)
    * You need to find the maximum gold that can be collected
*/

public class MyClass {
  static int maxGold(int n, int m, int[][] arr, int[][] dp) {
      if(m>=arr[0].length || n<0 || n>=arr.length){
          return 0;
      }
      if(dp[n][m]!=0){
          return dp[n][m];
      }
      
      int maxGold = arr[n][m];
      
      int up = maxGold(n-1, m+1, arr, dp);
      int right = maxGold(n, m+1, arr, dp);
      int down = maxGold(n+1, m+1, arr, dp);
      
      dp[n][m] = arr[n][m] + Math.max(up, Math.max(down, right));
      
      return dp[n][m];
    
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
       int[][] x = {
    { 12, 57, 89 },
    { 34, 37, 25 },
    { 10, 46, 68 }};
    
        int maxGoldCollected = 0;
        for(int i = 0; i < n; i++){
            maxGoldCollected = Math.max(maxGoldCollected, maxGold(i, 0, x, new int[n][m]));
        }
        System.out.println(maxGoldCollected);
        }
}