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
        // Edge case: Absolute value of x < 10
        if(x < 10 && x > -10) {
            return x;
        }

        int result = 0;
        boolean neg = x < 0;
        int max = neg ? Integer.MIN_VALUE / 10 : Integer.MAX_VALUE / 10;
        while(x != 0) {
            int r = x % 10;
            if((neg && result < max) || (!neg && result > max)) {
                return 0;
            }
            result = result*10 + r;
            x /= 10;
        }
        return result;
    }
}