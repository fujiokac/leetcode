/**
 * Given a non-empty array of decimal digits representing a non-negative integer,
 * increment one to the integer. The digits are stored such that the most significant
 * digit is at the head of the list, and each element in the array contains a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length -1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                break;
            }
            digits[i] = 0;
            if (i == 0) {
                return appendOne(digits);
            }
        }
        return digits;
    }

    private int[] appendOne(int[] digits) {
        int[] result = new int[digits.length +1];
        result[0] = 1;
        System.arraycopy(digits, 0, result, 1, digits.length);
        return result;
    }
}