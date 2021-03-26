class Solution {
    /**
     * Given an integer array nums, find the contiguous subarray (containing
     * at least one number) which has the largest sum and return its sum.
     * Constraints:
     * 1 <= nums.length <= 3 * 104
     * -105 <= nums[i] <= 105
     */
    public int maxSubArray(int[] nums) {       
        if nums.length == 0:
            return self.MIN
        if nums.length == 1:
            return nums[0]
        currentSum = nums[0]
        # this variation runs slower -- test case dependent?
        # maxSum = currentSum
        maxSum = max(currentSum, sum(nums))

        for i in range(1, nums.length):
            if currentSum < 0:
                currentSum = 0
            currentSum += nums[i]
            if currentSum > maxSum:
                maxSum = currentSum

        return maxSum
    }
}