/**
 * Given an input string 'S' and a pattern 'P', implement a regular expression matching with the support of two special characters ‘.’ (dot) and ‘*’(asterisk) where

1. ‘.’ matches to any single character.
2. ‘*’ matches to zero or more of the preceding element.
If the input string 'S' matches the pattern 'P', then return true else, return false.

Note:
1. You have to match the entire string with the pattern given.

2. Both the strings, 'S' and 'P' contain only lower-case alphabets.

3. Only the pattern will contain additional characters ‘*’ and ‘.’ along with alphabets.
 */

import java.util.*;
public class Solution 
{
	public static Boolean isMatch(String S, String P) {
		 int m = S.length();
        int n = P.length();

        // DP table
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty string matches empty pattern
        dp[0][0] = true;

        // Handle patterns with '*' in the first row (when S is empty)
        for (int j = 1; j <= n; j++) {
            if (P.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2]; // '*' acts as zero of the preceding element
            }
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = S.charAt(i - 1);
                char pChar = P.charAt(j - 1);

                if (pChar == sChar || pChar == '.') {
                    // Characters match or '.' matches any single character
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    // '*' can match zero of the preceding character
                    dp[i][j] = dp[i][j - 2];

                    // Or '*' can match one or more of the preceding character
                    char prevPChar = P.charAt(j - 2);
                    if (prevPChar == sChar || prevPChar == '.') {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
	}
}
