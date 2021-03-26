class Solution {
    /**
     * Given an integer array nums, find the contiguous subarray (containing
     * at least one number) which has the largest sum and return its sum.
     * Constraints:
     * 1 <= nums.length <= 3 * 104
     * -105 <= nums[i] <= 105
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int currentSum = nums[0];
        int maxSum = currentSum;

        for (int i = 1; i < nums.length; i++) {
            if (currentSum < 0)
                currentSum = 0;
            currentSum += nums[i];
            if (currentSum > maxSum)
                maxSum = currentSum;
        }

        return maxSum;
    }
}