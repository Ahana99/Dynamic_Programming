/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    public void backtrack(List<String> result, String current, int open, int close, int max){
        if(current.length()==max*2){
            result.add(current);
            return;
        }
        if(open<max){
            backtrack(result, current+"(", open+1, close, max);
        }
        if(close<open){
            backtrack(result, current+")", open, close+1, max);
        }
    }
}