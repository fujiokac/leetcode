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

		char[] hay = haystack.toCharArray(), need = needle.toCharArray();
		int[] last = new int[hay.length];
		for (int i = 0, j = 0, l = 1; i < hay.length - need.length + 1;) {
            for (j = 0; j < need.length; j++) {
				if (j > 0 && hay[i + j] == need[0]) {
					last[l] = i + j;
                    l = i + j;
				}
				if (hay[i + j] != need[j]) {
                    if (last[i] > i) {
                        i = last[i];
                    }
                    else {
                        i++;
                    }

					break;
				}
			}
			if (j == need.length) return i;
		}
		return -1;
    }
}