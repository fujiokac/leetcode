/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
*/
class Solution {
    // Naive solution
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        for(int letter = 0; ; letter++) {
            char c = ' ';
            for(int word = 0; word < strs.length; word++) {
                String current = strs[word];
                if(current.length() <= letter || (word != 0 && c != current.charAt(letter))) {
                    return prefix.toString();
                }
                if(word == 0) {
                    c = current.charAt(letter);
                }
            }
            if(c == ' ') {
                break;
            }
            prefix.append(c);
        }
        return prefix.toString();
    }
}