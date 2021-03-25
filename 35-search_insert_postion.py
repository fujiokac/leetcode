class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int

        constraints:
        1 <= nums.length <= 104
        -104 <= nums[i] <= 104
        nums contains distinct values sorted in ascending order.
        -104 <= target <= 104
        """

        if target <= nums[0]:
            return 0
        if target > nums[-1]:
            return len(nums)
        left = 0
        right = len(nums)
        while left < right:
            half = left + (right - left)/2
            if target == nums[half]:
                return half
            if target > nums[half]:
                left = half + 1
            else:
                right = half
        return left

