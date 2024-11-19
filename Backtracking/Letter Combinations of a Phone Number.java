/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 */

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] phoneMap = { "", "", "abc", "def",
                "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        List<String> result = new ArrayList<>();
        backtrack(digits, result, 0, phoneMap, new StringBuilder());
        return result;
    }

    public void backtrack(String d, List<String> result, int index, String[] pmap, StringBuilder current) {
        if(index==d.length()){
            result.add(current.toString());
            return;
        }

        String letters = pmap[d.charAt(index)-'0'];
        for(char l: letters.toCharArray()){
            //add
            current.append(l);
            //bactrack
            backtrack(d, result, index+1, pmap, current);
            //delete
            current.deleteCharAt(current.length()-1);
        }
    }
}