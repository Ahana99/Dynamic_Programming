/**
 * You are given an array ‘fruits’ of size ‘N’.
 * Your task is to find the longest sub-array in the given array such that the count of distinct numbers in the sub-array is less than or equal to 2.
 * The sub-array of an array is a contiguous section. For example, for the given array, {2,3,5,1,4} sub-arrays can be {2,3,5}, {3,5,1,4} and so on.
 * For Example:
    * Consider ‘fruits’ = [1, 2, 1, 3, 2], the longest subarray following the given condition is [1, 2, 1]. The length of the sub-array is 3.
 */

import java.util.HashMap;
public class Solution {

	public static int longestSubarray(int[] fruits) {
	 HashMap<Integer, Integer> count = new HashMap<>();
	 int maxLen = 0, start = 0;
	 for(int i = 0; i<fruits.length;i++){
		 count.put(fruits[i], count.getOrDefault(fruits[i], 0)+1);
		 while(count.size()>2){
			 int starting = fruits[start];
			 count.put(starting, count.get(starting)-1);
			 if(count.get(starting)==0){
				 count.remove(starting);
                }
			    start++;
		    }
		    maxLen = Math.max(maxLen, i-start +1);
        }
	 return maxLen;
	}

}
