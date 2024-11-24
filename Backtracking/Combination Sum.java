import java.util.*;
public class CombinationSum {
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        
        Arrays.sort(candidates);  // Sorting helps to handle duplicates easily
        backtrack(candidates, target, 0, currentCombination, result);
        
        return result;
    }

    // Backtracking function
    private static void backtrack(int[] candidates, int target, int startIndex, 
        List<Integer> currentCombination, List<List<Integer>> result) {
        if (target == 0) {
            // If the target is 0, we found a valid combination
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                // Skip duplicates
                continue;
            }

            if (candidates[i] > target) {
                // If the candidate exceeds the target, no point in continuing
                break;
            }

            // Include the candidate in the current combination
            currentCombination.add(candidates[i]);
            // Recursively call backtrack with the remaining target
            backtrack(candidates, target - candidates[i], i, currentCombination, result);
            // Backtrack, remove the last added element
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);

        System.out.println("Combinations that sum up to " + target + ": " + result);
    }
}
