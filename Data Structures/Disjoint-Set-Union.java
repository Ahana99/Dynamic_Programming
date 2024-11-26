/*
	You are given an array ‘POINTS’ having ‘N’ points located in a 2D plane and an integer ‘K’. Your task is to group them in such a way that if the euclidean distance between two points is less than or equal to ‘K’, group them together. This relation is chainable.
    For example, [P1,P2,P3], P1 to P2 <= ‘K’, P2 to P3<=k, P1 to P3>’K’. They are still in the same group. Return the number of groups formed.
    For Example
        If the given POINTS array is [(0,0),(1,1),(3,3)] and ‘K’ = 2, then the number of groups will be 2.
        One group will be [(0,0) , (1,1)] and other will be [(3,3)]. 
*/

import java.util.Arrays;

public class Solution {

	private static int findGroup(int i, int[] groups) {
		if (groups[i] == i) {
			return i;
		}

		return groups[i] = findGroup(groups[i], groups);
	}

	private static void unionGroup(int i, int j, int[] groups, int[] sizes) {
		int a = findGroup(i, groups);
		int b = findGroup(j, groups);

		if (a != b) {
			
			// Sizes compression.
			if (sizes[a] < sizes[b]) {
			
				// Swapping a and b.
				int tmp = a;
				a = b;
				b = tmp;
			}

			groups[b] = a;
			sizes[a] += sizes[b];
		}
	}

	// Returns the distance between points[a] and points[b].
	private static int distance(int a, int b, int[][] points) {
		int d1 = points[a][0] - points[b][0];
		int d2 = points[a][1] - points[b][1];
		return (d1 * d1 + d2 * d2);
	}

	public static int groupPoints(int n, int k, int[][] points) {

		// Groups array to store the group number of each point.
		int[] groups = new int[n];
		int[] sizes = new int[n];
		Arrays.fill(sizes, 1);

		for (int i = 0; i < n; i++) {
			groups[i] = i;
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (distance(i, j, points) <= k * k) {
					
					// If distance is less than or equal to k,group them together.
					unionGroup(i, j, groups, sizes);
				}
			}
		}

		// ans will store the number of groups.
		int ans = 0;

		for (int i = 0; i < n; i++) {
			
			// If group[i] == i denotes its a new group.
			if (groups[i] == i) {
				ans++;
			}
		}

		return ans;
	}

}
