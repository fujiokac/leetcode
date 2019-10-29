/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
*/
class Solution {
    // Bottom up solution using substring & while, faster at the cost of space
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            String word = strs[i];
            while(!word.startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}