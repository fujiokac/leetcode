/**
 * Given an array nums and a value val, remove all instances of that value
 * in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int fast = 0; i < nums.length && fast < nums.length; i++) {
            while (nums[fast] == val) {
                fast++;
                if (fast == nums.length) {
                    return i;
                }
            }
            nums[i] = nums[fast++];
        }
        return i;
    }
}