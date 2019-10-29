/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
*/
class Solution {
    // Top down solution using substring instead of StringBuilder
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        String base = strs[0];
        int end = base.length();
        for(int letter = 0; letter < end; letter++) {
            char c = base.charAt(letter);
            for(int word = 1; word < strs.length && strs[word].length() > letter; word++) {
                if(letter == strs[word].length() || c != strs[word].charAt(letter)) {
                    end = letter;
                }
            }
        }
        return base.substring(0, end);
    }
}