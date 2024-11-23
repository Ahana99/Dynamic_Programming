/**
 * Given two Arrays A[] and B[] of length N and M respectively.
 * Find the minimum number of insertions and deletions on the array A[], required to make both the arrays identical.
 * Note: Array B[] is sorted and all its elements are distinct, operations can be performed at any index not necessarily at end.
 */

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            
            int[] A = new int[N];
            int[] B = new int[M];
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);
                
            for(int i=0; i<M; i++)
                B[i] = Integer.parseInt(S2[i]);

            Solution ob = new Solution();
            System.out.println(ob.minInsAndDel(A,B,N,M));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minInsAndDel(int[] A, int[] B, int N, int M) {
         HashSet<Integer> bSet = new HashSet<>();
        for (int b : B) {
            bSet.add(b);
        }
        
        List<Integer> filteredA = new ArrayList<>();
        for (int a : A) {
            if (bSet.contains(a)) {
                filteredA.add(a);
            }
        }

        // Step 2: Map elements of B[] to indices for LIS
        HashMap<Integer, Integer> bIndexMap = new HashMap<>();
        for (int i = 0; i < M; i++) {
            bIndexMap.put(B[i], i);
        }

        // Replace filteredA with indices from B[]
        List<Integer> indexA = new ArrayList<>();
        for (int a : filteredA) {
            indexA.add(bIndexMap.get(a));
        }

        // Step 3: Find LIS on indexA
        int lis = lengthOfLIS(indexA);

        // Step 4: Compute insertions and deletions
        int deletions = N - lis;
        int insertions = M - lis;
        return deletions + insertions;
    }

    // Helper to calculate LIS length using binary search
    static int lengthOfLIS(List<Integer> nums) {
        List<Integer> lis = new ArrayList<>();
        for (int num : nums) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            if (pos == lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num);
            }
        }
        return lis.size();
    }
};