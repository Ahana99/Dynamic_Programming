/**
 * Given a string str consisting of opening and closing parenthesis '(' and ')'. Find the length of the longest valid parenthesis substring.
 * A parenthesis string is valid if:
    * For every opening parenthesis, there is a closing parenthesis.
    * The closing parenthesis must be after its opening parenthesis.
 */

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        if(S == null || S.length() == 0) return 0;
        int maxLength = 0;
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        for(int i=0; i<S.length();i++){
            if(S.charAt(i)=='('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    maxLength = Math.max(maxLength, i-st.peek());
                }
            }
        }
        return maxLength;
    }
}