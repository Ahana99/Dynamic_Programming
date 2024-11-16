/**
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 */

class Solution {
    public int candy(int[] ratings) {
        if(ratings.length<=1){
            return ratings.length;
        }
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for(int i = 1; i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i] = candy[i-1] +1;
            }
        }
        for(int i=ratings.length-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                candy[i] = Math.max(candy[i], candy[i+1]+1);
            }
        }
        int count = 0;
        for(int i=0;i<ratings.length;i++){
            count+=candy[i];
        }

        return count;
    }
}