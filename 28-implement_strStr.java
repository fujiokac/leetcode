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

		for (int i = 0, j = 0, hay = haystack.length(), need = needle.length(); i < hay - need + 1; i++) {
			j = 0;
			while (j < need) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
				j++;
			}
			if (j == need) return i;
		}
		return -1;
    }
}