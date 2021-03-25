class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        return self.findNextHighest(nums, target)

    def findNextHighest(self, nums, target):
        length = len(nums)
        if length == 0:
            return 0
        if length == 1:
            return 0 if target <= nums[0] else 1
        else:
            half = length/2
            if target == nums[half]:
                return half
            if target < nums[half]:
                return self.findNextHighest(nums[:half], target)
            else:
                return half + self.findNextHighest(nums[half:], target)