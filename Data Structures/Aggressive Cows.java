public class Solution {
    public static int aggressiveCows(int []stalls, int k) {
       Arrays.sort(stalls);
       int n = stalls.length;
       int low = 1;
       int high = stalls[n-1] - stalls[0];
       int result = 0;
       while(low<=high){
           int mid = low+(low+high)/2;
           if(canPlaceCow(n, k, stalls, mid)){
               result = mid;
               low=mid+1;
           }
           else{
               high = mid-1;
           }
       }
       return result;
    }
    public static boolean canPlaceCow(int n, int k, int[] stalls, int pos){
        int flag=1;
        int last =stalls[0];
        for(int i = 1;i<n;i++){
            if(stalls[i]-last >=pos){
                flag++;
                last = stalls[i];

                if(flag == k) return true;
            }
        }

        return false;
    }
}