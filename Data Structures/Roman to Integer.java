/**
 * Given a roman numeral, convert it to an integer.
 */

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        int result = 0;
        int prev = 0;
        for(int i=s.length()-1;i>=0;i--){
            int curr = romanMap.get(s.charAt(i));
            if(curr<prev){
                result-=curr;
            }
            else{
                result+=curr;
            }
            prev=curr;
        }
        return result;
    }
}