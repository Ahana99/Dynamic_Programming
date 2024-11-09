/**
    * You are given a number n, representing the number of stairs in a staircase
    * You are on the 0th step and you are required to climb to the top
    * You  are given n numbers, where the i-th element's value represents: how far you can jump from that step at once
    * So if you have arr[1]=3, you can jump to 2nd, 3rd and 4th step but not further than that.
    * You are required to print the minimum number of move in which you can climb to the top, if no path exists print null
*/

public class MyClass {
  static Integer countWays(int step, int n, int[] arr, Integer[] dp) {
		if(step>=n){
          return 0;
        }
        
        if(dp[step]!=null){
          return dp[step];
        }
    
        int minMoves = Integer.MAX_VALUE;
        for(int i=1; i<=arr[step] && step+i<=n; i++){
            Integer moves = countWays(step+i, n, arr, dp);
            if(moves!=null){
                minMoves = Math.min(minMoves, 1+moves);
            }
        }
        if(minMoves == Integer.MAX_VALUE){
            dp[step]=null;
        }
        else{
            dp[step]=minMoves;
        }
      return dp[step];
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {1,1,1,4,9,8,1,1,10,1};
        System.out.println(countWays(0, n, arr, new Integer[n+1]));
    }
}