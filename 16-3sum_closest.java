/**
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        Arrays.sort(nums);
        return findTarget(nums, target);
    }

    private int findTarget(int[] sorted, final int target) {
        int closest = sorted[0] + sorted[1] + sorted[2];
        int diff = Math.abs(closest - target);

        for (int lo = 0, end = sorted.length; lo < end - 2 && diff != 0; lo++) {
            // Upper bound
            if (sorted[lo] + sorted[end-1] + sorted[end-2] < target) {
                closest = sorted[lo] + sorted[end-1] + sorted[end-2];
                diff = Math.abs(closest - target);
                continue;
            }

            // Lower bound
            if (sorted[lo] + sorted[lo+1] + sorted[lo+2] > target) {
                int temp = sorted[lo] + sorted[lo+1] + sorted[lo+2];
                if (Math.abs(target - temp) <= diff) {
                    closest = temp;
                }
                break;
            }

            // Remaining values
            int mid = lo + 1;
            int hi = end - 1;
            while(hi > mid) {
                int temp = sorted[lo] + sorted[mid] + sorted[hi];
                if (temp == target) {
                    return target;
                }
                if(temp < target) {
                    mid++;
                }
                else {
                    hi--;
                }
                int tempDiff = Math.abs(target - temp);
                if (tempDiff <= diff) {
                    closest = temp;
                    diff = tempDiff;
                }
            }
        }

        return closest;
    }
}