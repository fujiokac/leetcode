/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 */
class Solution {
    public int strStr(String haystack, String needle) {
    	if (needle.isEmpty()) return 0;
    	if (haystack.isEmpty()) return -1;

		for (int i = 0, hay = haystack.length(), need = needle.length(); i < hay - need + 1; i++) {
			for (int j = 0; j < need; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
				if (j == need-1) return i;
			}
		}
		return -1;
    }
}