class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumOriginal = (n*(n+1))/2 ;
        int sumActual = 0;
        for(int val: nums){
            sumActual+=val;
        }
        int diff = sumOriginal - sumActual;
        return diff;
    }
}