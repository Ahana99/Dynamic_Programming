/**
 * Given a string s and a dictionary of strings wordDict
 * Return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
     Set<String> wordSet = new HashSet<>(wordDict); // Convert to a Set for faster lookups
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        // Base case
        dp[0] = true;

        // Iterate over the string
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if the substring s[j:i] is in the dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further
                }
            }
        }

        return dp[n];   
    }
}