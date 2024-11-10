/**
    * You are given n: no. of coins denomination (eg.: 3)
    * You are given n number of coin denominations (eg.: [2,3,5])
    * You are given an amount amt
    * You are required to calculate the number of combinations in which you can pay the amount using the denominations given
    * You can use infinite number of coins for a particular denomination
*/

public class MyClass {
  static int coinComb(int amt, int[] coins, int[] dp) {
      if(amt==0){
          return 0;
      }
      
      if(amt<0){
          return Integer.MAX_VALUE;
      }
      if(dp[amt]!=-1){
         return dp[amt];
      }
      int minVal= Integer.MAX_VALUE;
      
      for(int c: coins){
          int minCoins = coinComb(amt-c,coins, dp);
          if(minCoins!= Integer.MAX_VALUE){
              minVal = Math.min(minVal, minCoins+1);
          }
      }
      dp[amt] = minVal;
      
      return minVal == Integer.MAX_VALUE? -1 : minVal;
    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int amt = 7;
       int[] dp = new int[amt+1];
       Arrays.fill(dp, -1);
       dp[0]=0;
        System.out.println(coinComb(amt, coins, dp));
        }
}