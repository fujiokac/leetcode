/**
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000
 */

/**
 * Design thoughts:
 *
 * Naive solution, iterate through each letter,
 * counting left & right until characters don't match
 *
 * Ways to optimize:
 * -- Longest possible palindrome would "begin" at the middle of the string, start search there
 * -- If the search gets towards the edges, the possible longest length decreases
 *      Corollaries:
 *      -- If a palindrome hits the stringe edge and is current max length, it is the largest possible
 *      -- If the search reaches an index such that len-2*i < current max,
 *      (with i being distance from center), the current max is the largest possible
 *
 * Cases:
 * -- Empty or single letter case
 * -- How to handle even & odd palindromes e.g. abba and aba?
 *      left-right starting indices
 *
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution(args[0]);
    }

    public Solution(String s) {
        System.out.println(longestPalindrome(s));
    }
    /**
     * Initialize array to store lenth & indices of longest known substring
     * Use -1 to indicate no data
     */
    private int[] max = {-1,-1,-1};

    public String longestPalindrome(String s) {
        int len = s.length();
        // lengths 0 & 1 are their own maximum substrings
        if(len < 2) {
            return s;
        }

        // Start from the middle where longest potential substrings
        int halfway = len/2;
        for(int i = 0; i <= halfway && !earlyEndCondition(len, i) ; i++) {
            // Offset left & right from middle
            for(int neg = 1; neg > -2; neg-=2) {
                int offset = i*neg + halfway;
                // Checking for palindrome of odd length
                int[] odd = longestPalindromeAt(s, offset, offset, len);
                if(odd[0] > max[0]) {
                    max = odd;
                }

                // Checking for palindrome of even length
                if(offset > 0) {
                    int[] even = longestPalindromeAt(s, offset-1, offset, len);
                    if(even[0] > max[0]) {
                        max = even;
                    }
                }
            }
        }
        // Returning longest substring
        return s.substring(max[1],max[2]);
    }

    /**
     * Conditions under which search can terminate early:
     * 1. Current max substring is longer or equal to any possible substring lengths at index i
     * 2&3. Current max substring abuts the beginning or end of the string
     * (only possible because searching from the middle)
     */
    public boolean earlyEndCondition(int len, int i) {
        return max[0] > len - 2*i || max[1] == 0 || max[2] == len;
    }

    /**
     * Search from indices left & right until characters do not match.
     */
    public int[] longestPalindromeAt(String s, int left, int right, int len) {
        int upper = 0, lower= 0;
		while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
		    lower = left--;
		    upper = ++right;
		}
		// Upper bound is exclusive, so ++ is ok, lower bound is inclusive
        int[] substring = {upper-lower, lower, upper};
        return substring;
    }
}