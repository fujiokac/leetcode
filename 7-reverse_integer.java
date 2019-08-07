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
        // Common Case
        int result = 0;
        int previous = 0;
        while(x != 0) {
            previous = result;
            result = result*10 + x % 10;
            x /= 10;
            // If overflow, result/10 will not = previous
            if(result / 10 != previous) {
                return 0;
            }
        }
        return result;
    }
}