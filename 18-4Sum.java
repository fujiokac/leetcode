/**
 * Given an array nums of n integers and an integer target,
 * are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 */
class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        ArrayList<List<Integer>> quads = new ArrayList<>();

        for (int i = 0; i < nums.length-3;) {
            for (int j = nums.length-1; j > i+2;) {
                int base = nums[i] + nums[j];
                // Test high end (i is too low):
                if (base + nums[j-1] + nums[j-2] < target) {
                    break;
                }

                // Test low end (skip if j is too high):
                if (base + nums[i+1] + nums[i+2] <= target) {
                   for (int l = i+1, r = j-1; l < r;) {
                        int temp = base + nums[l] + nums[r];
                        if (temp == target) {
                            quads.add(Arrays.asList(nums[i], nums[l], nums[r], nums[j]));
                        }
                        // increase left
                        if (temp <= target) {
                            while (l < r && nums[l] == nums[++l]) {}
                        }
                        // decrease right
                        if (temp >= target) {
                            while (r > l && nums[r] == nums[--r]) {}
                        }
                    }
                }
                while (j > i+2 && nums[j] == nums[--j]) {}
            }
            while (i < nums.length-3 && nums[i] == nums[++i]) {}
        }

        return quads;
    }
}