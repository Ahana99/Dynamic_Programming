/**
 * You are given a string str.
 * You are required to calculate and print the count of subsequences of the nature a+b+c+.
    For abbc - there are 3 subsequences. abc, abc, abbc
    For abcabc - there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.
 */
import java.util.*;
public class MyClass {
  public static void main(String args[]) {
   String str = "abcabc";
    System.out.println(decode(str));
  }
  
  public static int decode(String str){
    Map<String, Integer> dp = new HashMap<>();

     dp.put("a", 0);
     dp.put("ab", 0);
     dp.put("abc", 0);
     
     for(char c: str.toCharArray()){
         int a = dp.get("a");
         int ab = dp.get("ab");
         int abc = dp.get("abc");
         if(c == 'a'){
             dp.put("a", 2*a+1);
         }
         else if(c == 'b'){
             dp.put("ab", 2*ab+a);
         }
         else if(c == 'c'){
             dp.put("abc", 2*abc+ab);
         }
     }
     return dp.get("abc");
  }
}