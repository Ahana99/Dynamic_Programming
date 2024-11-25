/**
 * Find the contiguous subarray with the largest sum.
 */

public int lengthOfLongestSubstring(String s) {
    int maxLen = 0;
    int start = 0;
    Map<Character, Integer> charIndexMap = new HashMap<>();

    for (int end = 0; end < s.length(); end++) {
        char currentChar = s.charAt(end);

        // If character is already in the map, move the start pointer
        if (charIndexMap.containsKey(currentChar)) {
            start = Math.max(start, charIndexMap.get(currentChar) + 1);
        }

        // Update the character's position in the map
        charIndexMap.put(currentChar, end);

        // Calculate the maximum length of the substring
        maxLen = Math.max(maxLen, end - start + 1);
    }

    return maxLen;
}
