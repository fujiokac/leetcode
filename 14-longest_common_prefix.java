/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
*/
class Solution {
    // Bottom up solution using substring instead of StringBuilder
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        String base = strs[0];
        int end = base.length();
        for(int letter = end-1; letter > -1; letter--) {
            char c = base.charAt(letter);
            for(int word = 1; word < strs.length; word++) {
                if(!base.equals(word)) {
                    int length = strs[word].length();
                    if(length <= letter) {
                        end = length;
                        letter = length;
                    }
                    else if(c != strs[word].charAt(letter)) {
                        end = letter;
                    }
                }
            }
        }
        return base.substring(0, end);
    }
}