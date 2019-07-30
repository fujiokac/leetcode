/**
 * Given a string, find the length of the longest substring without repeating characters.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // If string length 0 or 1, length = longest substring
        if(len < 2) {
            return len;
        }
        // Create array-index map of all ASCII characters, initialize with -1
        int[] map = new int[128];
        Arrays.fill(map, -1);
        
        int max = 0, left = 0, right = 0;
        // Loop through characters in string
        for(; right < len; right++) {
            char ch = s.charAt(right);
            // Update left cursor when duplicate char found with previous index of char
            if (map[ch] >= left) {
                // Compare current substring length with longest found
                max = Math.max(max, right - left);
                left = map[ch] + 1;
            }
            // Update array with new index of char
            map[ch] = right;
	    }
	    // Compare max with possible case of all unique char
	    return Math.max(right - left, max);
    }
}