/**
    * You are given a number n, representing the number of stairs in a staircase
    * You are on the 0th step and you are required to climb to the top
    * You  are given n numbers, where the i-th element's value represents: how far you can jump from that step at once
    * So if you have arr[1]=3, you can jump to 2nd, 3rd and 4th step but not further than that.
    * You are required to print the number of different paths in which you can climb to the top
*/

public class MyClass {
  static int countWays(int step, int n, int[] arr, int[] dp) {
	if(step==n){ \\if you have reached the last step
          return 1;
        }else if(dp[step]!=0){
          return dp[step]; \\memoization
        }
        int sum = 0;

        \\ the step you are on + the amount jump you can make from there should not be more than the avialable steps
        for(int i=1; i<=arr[step] && step+i<=n; i++){ 
            sum+=countWays(step+i, n, arr, dp);
        }
      dp[step]=sum;
	  
      return dp[step];
    }

    public static void main(String[] args) {
        int n = 13;
        int[] arr = {5,5,2,4,1,5,9,8,6,3,8,9,1};
        System.out.println(countWays(0, n, arr, new int[n+1]));
    }
}
