/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
*/
class Solution {
    /**
     * Divide & conquer solution using substring
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String prefix = strs[0];
        // Iterate through each word to narrow down prefix
        for (int i = 1; i < strs.length; i++){
            prefix = findPrefix(prefix, strs[i]);
        }
        return prefix;
    }

    /**
     * Uses binary recursion to find prefix
     */
    private String findPrefix(String prefix, String word) {
        if(prefix.isEmpty() || word.isEmpty()) {
            return "";
        }
        if (prefix.length() == 1) {
            return word.startsWith(prefix) ? prefix : "";
        }

        if (!word.startsWith(prefix)) {
            // Find pivot
            int mid = prefix.length() / 2;
            // Check left half
            String temp = findPrefix(prefix.substring(0, mid), word);
            // If left half is prefix, check right half & append
            if(temp.length() == mid) {
                temp += findPrefix(prefix.substring(mid, prefix.length()), word.substring(mid, word.length()));
            }
            // Save new prefix
            prefix = temp;
        }
        return prefix;
    }
}