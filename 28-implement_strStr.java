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

		// Faster than String.charAt()
		char[] hay = haystack.toCharArray(), need = needle.toCharArray();
		// Tracks next index of first letter
		int[] kmp = new int[hay.length];

		for (int i = 0, n = 0, h = 0, last = 0; i < hay.length - need.length + 1; ) {
            for (n = 0; n < need.length; n++) {
                h = i + n;

                // Check & track first letter matches
				if (n > 0 && hay[h] == need[0] && h > last) {
					kmp[last] = h;
                    last = h;
				}
				// Check substring match
				if (hay[h] != need[n]) {
                    break;
				}
			}
			// Substring match
			if (n == need.length) return i;

			// Jump to next known occurrence of first letter
			i = kmp[i] > i ? kmp[i] : i+1;
		}
		// No match ):
		return -1;
    }
}