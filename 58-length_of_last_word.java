class Solution {
    /**
     * Given a string s consists of some words separated by spaces,
     * return the length of the last word in the string.
     * If the last word does not exist, return 0.
     *
     * A word is a maximal substring consisting of non-space characters only.
     */
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() -1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count > 0) break;
            }
            else
                count++;
        }
        return count;
    }
}