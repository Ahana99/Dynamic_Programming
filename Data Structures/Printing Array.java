/**
 * You are given various subsequences of a particular array.
 * You have to return the overall array from these given subsequences.
 * A subsequence of an array is a sequence that can be derived from the array by deleting 0 or more elements without changing the order.
 * For example, for the given array [1, 2, 3, 4, 5], a few valid subsequences are [1, 3, 5], [2, 4], [1, 2, 3, 4, 5].
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	private static void topologicalSort(int node, HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> visited,
			ArrayList<Integer> nodes) {
		
		// Add current node to visited node set
		visited.add(node);

		// Iterate over all the children of the visited nodes
		for (int i = 0; graph.containsKey(node) && i < graph.get(node).size(); i++) {
			int children = graph.get(node).get(i);

			if (!visited.contains(children))
				topologicalSort(children, graph, visited, nodes);
		}

		// Insert the processed node in the node list
		nodes.add(node);
	}

	public static int[] makeArray(int n, int[][] subsequences) {
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

		// Iterate over all subsequences
		for (int i = 0; i < subsequences.length; i++) {
			int[] subseq = subsequences[i];

			for (int j = 1; j < subseq.length; j++) {
				
				// Make an edge from j - th to jth node
				if (graph.containsKey(subseq[j - 1])) {
					ArrayList<Integer> list = graph.get(subseq[j - 1]);
					list.add(subseq[j]);
					graph.put(subseq[j - 1], list);
				} else {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(subseq[j]);
					graph.put(subseq[j - 1], list);
				}

			}
		}

		ArrayList<Integer> nodes = new ArrayList<Integer>();
		HashSet<Integer> visited = new HashSet<>();

		// Get the topological sort of the graph
		for (HashMap.Entry<Integer, ArrayList<Integer>> entry : graph.entrySet()) {
			int node = entry.getKey();

			if (!visited.contains(node))
				topologicalSort(node, graph, visited, nodes);

		}

		// Reverse and return the list of nodes
		Collections.reverse(nodes);
		int ansArr[] = new int[nodes.size()];
		for (int i = 0; i < nodes.size(); i++) {
			ansArr[i] = nodes.get(i);
		}
		return ansArr;
	}
}
