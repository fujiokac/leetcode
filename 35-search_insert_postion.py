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
        elif target > nums[-1]:
            return len(nums)
        for i in range(1, len(nums)):
            if target <= nums[i]:
                return i