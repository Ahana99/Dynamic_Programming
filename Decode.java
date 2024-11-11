/**
 * You are given a string str of digits. (will never start with a 0)
 * You are required to encode the str as per following rules
    1 - a
    2 - b
    3 - c
    ..
    25 - y
    26 - z
 * You are required to calculate and print the count of encodings for the string str.
     For 123 - there are 3 encodings. abc, aw, lc
     For 993 - there is 1 encoding. iic 
     For 013 - This is an invalid input. A string starting with 0 will not be passed.
     For 103 - there is 1 encoding. jc
     For 303 - there are 0 encodings. But such a string maybe passed. In this case 
     print 0.
 */
public class MyClass {
  public static void main(String args[]) {
   String str = "226";

    System.out.println(decode(str, 0, new int[str.length()]));
  }
  
  public static int decode(String str, int index, int[] dp){
      if(index==str.length()){
          return 1;
      }
      if(str.charAt(index)=='0'){
          return 0;
      }

      if(dp[index]!=0){
          return dp[index];
      }
     int ways = decode(str, index+1, dp);
     if(index+1<str.length()){
         int digits = Integer.parseInt(str.substring(index,index+2));
             if(digits>=10 && digits<=26){
                ways+=decode(str, index+2, dp);

             }
         }
     dp[index]=ways;
     
     return dp[index]; 
  }
}