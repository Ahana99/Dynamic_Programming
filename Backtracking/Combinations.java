/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(n,k,1,new ArrayList<>(),result);
        return result;
    }
    public void backtrack(int n, int k, int start, List<Integer> current, List<List<Integer>> result){
        if(current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start; i<=n;i++){
            current.add(i);
            backtrack(n,k,i+1,current, result);
            current.remove(current.size()-1);
        }
    }
}