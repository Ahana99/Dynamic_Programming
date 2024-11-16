/**
 * Given a string s, return the longest palindromic substring in s.
 */

class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length()<1){
            return "";
        }

        int n= s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, max = 0;

        for(int i =1; i<=n;i++){
            for(int j=0; j<=n-i;j++){
                int index=i+j-1;
                if(s.charAt(j)==s.charAt(index)){
                    if(i==1 || i==2){
                        dp[j][index]=true;
                    }else{
                        dp[j][index]=dp[j+1][index-1];
                    }
                    if(dp[j][index] && i>max){
                        start=j;
                        max=i;
                    }
                }
            }
        }

        return s.substring(start, start+max);
    }
}