/**
 * You are given a number n, representing the number of stairs in a staircase
 * You are on the 0th step and you are required to climb to the top
 * In one move, you are allowed to climb 1, 2 or 3 stairs
 * Find the number of different paths with which you can climb the stairs
 */

class GfG {
    static int countWays(int n,int[] arr) {
		if(n==0){
          return 1;
        }else if(n<0){
          return 0;
        }else if(arr[n]!=0){
          return arr[n];
        }
        int sum = countWays(n - 1, arr) + countWays(n - 2, arr) + countWays(n-3,arr);
      arr[n]=sum;
      return sum;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countWays(n, new int[n+1]));
    }
}