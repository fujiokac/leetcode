/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * [-1,0,1,2,-1,-4]
 * [-1,0,1,0]
 * [-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
 * [-2,0,1,1,2]
 * [0,0,0,0]
 * [0,1,2,-1,4,1]
 * [3,0,-2,-1,1,2]
 */
class Solution {
    private int[] intMap;

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        if(nums.length == 3) {
            if(nums[0] + nums[1] + nums[2] == 0) {
                return Collections.singletonList(Arrays.asList(nums[0], nums[1], nums[2]));
            }
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        // Check that positive & negative (or zero) values exist
        if (nums[0] > 0 || nums[nums.length-1] < 0) {
            return Collections.emptyList();
        }

        // Create an array map of # times for each value in nums
        intMap = new int[nums[nums.length-1] - nums[0] + 1];
        for (int i = 0; i < nums.length; i++) {
            intMap[nums[i]-nums[0]]++;
        }

        return findTriplets(nums);
    }

    private List<List<Integer>> findTriplets(int[] sorted) {
        ArrayList<List<Integer>> triplets = new ArrayList<>();
        for (int lo = 0; lo < sorted.length - 2; lo++) {
            // No remaining combinations on current value
            if (sorted[lo] > 0) {
                break;
            }
            // Identical value to previous
            if (lo > 0 && sorted[lo] == sorted[lo - 1]) {
                continue;
            }
            // Zero triplet check
            if (sorted[lo] == 0 && sorted[lo + 1] == 0 && sorted[lo + 2] == 0) {
                triplets.add(Arrays.asList(0, 0, 0));
                continue;
            }
            // Check remaining values
            for (int hi = sorted.length - 1; hi > lo + 1; hi--) {
                // No remaining combinations on current value
                if (sorted[hi] < 0) {
                    break;
                }
                // Identical value to previous
                if (hi < sorted.length - 1 && sorted[hi] == sorted[hi + 1]) {
                    continue;
                }

                int mid = 0 - sorted[lo] - sorted[hi];
                // Value out of range -- hi is too high
                if (mid < sorted[lo]) {
                    continue;
                }
                // Value out of range -- lo is too low
                if (mid > sorted[hi]) {
                    break;
                }
                // Check if mid exists in sufficient quantity
                if (intMap[mid - sorted[0]] > (mid == sorted[lo] || mid == sorted[hi] ? 1 : 0)) {
                    triplets.add(Arrays.asList(sorted[lo], mid, sorted[hi]));
                }
            }
        }

        return triplets;
    }
}