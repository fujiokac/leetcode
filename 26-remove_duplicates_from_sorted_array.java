/**
 * Given a sorted array nums, remove the duplicates in-place
 * such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by
 * modifying the input array in-place with O(1) extra memory.
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        for (int start = 0, end = 1; i < nums.length && end < nums.length; i++) {
            while (nums[start] == nums[end]) {
                end++;
                if (end >= nums.length) {
                    return i;
                }
            }
            nums[i] = nums[end];
            start = end++;
        }
        return i;
    }
}