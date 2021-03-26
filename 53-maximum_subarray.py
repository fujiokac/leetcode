class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # Given an integer array nums, find the contiguous subarray (containing
        # at least one number) which has the largest sum and return its sum.
        # Constraints:
        # 1 <= nums.length <= 3 * 104
        # -105 <= nums[i] <= 105
        if len(nums) == 1:
            return nums[0]
        currentSum = nums[0]
        # this variation runs slower -- test case dependent?
        maxSum = currentSum
        # maxSum = max(currentSum, sum(nums))

        for i in range(1, len(nums)):
            currentSum = nums[i] if currentSum < 0 else currentSum + nums[i]
            if maxSum < currentSum:
                maxSum = currentSum

        return maxSum
