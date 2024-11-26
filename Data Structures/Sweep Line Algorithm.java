/**
 * Kurapika is long lost from his friends. He wants to meet his friends.
 * He has total ‘n’ friends, and everyone is not available on the same day.
 * But he can meet his friends only once. Given two arrays, ‘s’ and ‘e’, where s[i] denotes the starting date when an ith friend is available, and e[i] denotes when the ith friend will not be available after this date.
 * Help Kurapika to know what is the maximum number of friends he can meet on one single day.
 */

import java.util.*;

public class Solution {
    public static int maxFriends(int n, int[] s, int[] e) {
       List<int[]> friends = new ArrayList<>();
       for(int i=0;i<n;i++){
           friends.add(new int[]{s[i], 1});
           friends.add(new int[]{e[i]+1, -1});
       }
           Collections.sort(friends, (a,b) -> a[0]==b[0]? a[1]-b[1] : a[0]-b[0]);

           int active = 0, maxActive =0;
           for(int[] frnd: friends){
                active+=frnd[1];
                maxActive = Math.max(maxActive, active);
           }

       return maxActive;
    }
}