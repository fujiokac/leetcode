/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Assume we are dealing with an environment which could only
 * store integers within the 32-bit signed integer range: [−2^31, 2^31 − 1].
 * For the purpose of this problem, assume that your function
 * returns 0 when the reversed integer overflows.
 */

 class Solution {
    public static void main(String[] args) {
        Solution s = new Solution(args);
    }

    public Solution(String[] args) {
        System.out.println(reverse(Integer.valueOf(args[0])));
    }

    public int reverse(int x) {
        if(Math.abs(x) < 10) {
            return x;
        }
        return reverseH(x);
    }

    public int reverseH(int x) {
        boolean neg = x < 0;
        // Convert x and min/max value into strings
        String xString = String.valueOf(x);
        String max = String.valueOf(neg ? Integer.MIN_VALUE : Integer.MAX_VALUE);

        int len = xString.length();
        char[] reversed = new char[len];
        // True if possibility of overflow
        boolean checkOverflow = len == max.length();

        // Iterate backwards over string value
        for(int l = 0, r = len-1; l < len; l++, r--) {
            // Handle negative values
            if(l == 0 && neg) {
                reversed[l] = '-';
                l++;
            }
            // Current digit under comparison
            char digit = xString.charAt(r);
            // If checkOverflow is flagged, compare digit to max digit at new location
            if(checkOverflow) {
                // Current digit is less than max digit, no longer risk of overflow
                if(digit < max.charAt(l)) {
                    checkOverflow = false;
                }
                // Current digit is greater than max digit -- overflow case
                else if(digit > max.charAt(l)) {
                    return 0;
                }
                // If digit == max digit, not overflow, but risk remains
            }
            // Valid digit added to array
            reversed[l] = digit;
        }
        // Convert char array to String to int
        return Integer.valueOf(String.valueOf(reversed));
    }
}