/**
 * You are at your friend’s birthday party and one of your friends decided to play a card game with some special type of cards. These cards can have numbers written on both sides.
 * You are given ‘N’ cards, each card contains some integer number between ‘1’ to ‘10’ written on both sides. You are allowed to flip a card such that the number which was previously on the top now comes at the bottom and vice versa.
 * Find the minimum flips that need to be performed to make all the numbers equal on either the top sides or the bottom sides. If it is impossible to make all the cards the same on either side then return ‘-1’.
 * For Example :
    * If N = 4 and the numbers on the top sides are: { 1, 2, 3, 2 } and the numbers on the bottom sides are: { 2, 4, 2, 2}
    * Then the minimum number of flips required is equal to 1.
    * We can flip the 2nd card, the top sides now become: { 1, 4, 3, 2 } and the bottom sides are: { 2, 2, 2, 2}.
    * This results in getting the same numbers on the bottom side.
 */

public class Solution {
    public static int minCardFlips(int n, int[] tops, int[] bottoms) {
        Map<Integer, Integer> top = new HashMap<>();
        Map<Integer, Integer> bottom = new HashMap<>();

        for(int i=0;i<n;i++){
            top.put(tops[i], top.getOrDefault(tops[i],0)+1);
            bottom.put(bottoms[i], bottom.getOrDefault(bottoms[i],0)+1);
        }
        int minFlips = Integer.MAX_VALUE;
        Set<Integer> cards = new HashSet<>();
        cards.addAll(bottom.keySet());
        for(int c: cards){
            int flipTop =0, flipBottom = 0;
            for(int i=0; i<n; i++){
                if(tops[i]!=c && bottoms[i]!=c){
                    flipTop = Integer.MAX_VALUE;
                    break;
                }
                if(tops[i]!=c){
                    flipTop++;
                }
            }
            for(int i=0; i<n; i++){
                if(bottoms[i]!=c & tops[i]!=c){
                    flipBottom = Integer.MAX_VALUE;
                    break;
                }
                if(bottoms[i]!=c){
                    flipBottom++;
                }
            }

            if(flipTop!=Integer.MAX_VALUE){
                minFlips = Math.min(minFlips, flipTop);
            }
            if(flipBottom!=Integer.MAX_VALUE){
                minFlips = Math.min(minFlips, flipBottom);
            }
        }

        return minFlips == Integer.MAX_VALUE? -1 : minFlips;
    }
}