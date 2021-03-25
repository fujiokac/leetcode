class Solution {
    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     *
     * Constraints:
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums contains distinct values sorted in ascending order.
     * -104 <= target <= 104
     */
    public int searchInsert(int[] nums, int target) {
        if(target <= nums[0]) return 0;
        if(target >=
        int left = 0, right = nums.length;
        while(left < right) {
            int half = left + (right - left)/2;
            if(target == nums[half]) return half;
            if(target > nums[half])
                left = half + 1;
            else
                right = half;
        }
        return left;
    }
}