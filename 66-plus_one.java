/**
 * Given a non-empty array of decimal digits representing a non-negative integer,
 * increment one to the integer. The digits are stored such that the most significant
 * digit is at the head of the list, and each element in the array contains a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n-1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            }
            else {
                digits[i]++;
                return digits;
            }
        }
        /*
         * Only called in the case all digits are 9
         * Therefore returns array with length+1
         * of 1 followed by 0s
         */
        int[] result = new int[n+1];
        result[0] = 1;
        return result;
    }
}