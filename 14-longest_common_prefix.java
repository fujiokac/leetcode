/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
*/
class Solution {
    // More readable solution
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        for(int letter = 0; ; letter++) {
            char c = commonLetterAt(letter, strs);
            if(c == 0) {
                break;
            }
            prefix.append(c);
        }
        return prefix.toString();
    }

    private char commonLetterAt(int i, String[] strs) {
        char c = 0;
        for(int word = 0; word < strs.length; word++) {
            if(strs[word].length() <= i || (word != 0 && c != strs[word].charAt(i))) {
                return 0;
            }
            if(word == 0) {
                c = strs[word].charAt(i);
            }
        }
        return c;
    }
}