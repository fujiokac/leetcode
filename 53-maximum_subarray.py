class Solution:
    MIN = -math.pow(10,5)
    def maxSubArray(self, nums: List[int]) -> int:
        # Given an integer array nums, find the contiguous subarray (containing
        # at least one number) which has the largest sum and return its sum.
        # Constraints:
        # 1 <= nums.length <= 3 * 104
        # -105 <= nums[i] <= 105
        if len(nums) == 0:
            return self.MIN
        if len(nums) == 1:
            return nums[0]
        numSum = sum(nums)
        low = nums.index(min(nums))
        return max(sum(nums), self.maxSubArray(nums[:low]), self.maxSubArray(nums[low+1:]))
