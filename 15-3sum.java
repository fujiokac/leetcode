/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 */
class Solution {
    private HashSet<Integer> numSet;
    private HashSet<Integer> duplicates;

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

        initSets(nums);
        Arrays.sort(nums);
        return findTriplets(nums);
    }

    private List<List<Integer>> findTriplets(int[] sorted) {
        ArrayList<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < sorted.length-2; i++) {
            if (i > 0 && sorted[i] == sorted[i-1]) {
                continue;
            }
            for (int j = sorted.length-1; j > i+1; j--) {
                if (j < sorted.length-1 && sorted[j] == sorted[j+1]) {
                    continue;
                }
                int difference = 0 - sorted[i] - sorted[j];
                if (difference < sorted[i] || difference > sorted[j]) {
                    // Break doesn't work here...
                    continue;
                }
                if (isTriple(sorted[i], sorted[j], difference)) {
                    triplets.add(Arrays.asList(sorted[i], difference, sorted[j]));
                }
            }
        }

        return triplets;
    }

    private void initSets(int[] nums) {
        numSet = new HashSet<>();
        duplicates = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(!numSet.add(nums[i])) {
                duplicates.add(nums[i]);
            }
        }
    }

    private boolean isTriple(int a, int b, int difference) {
        return
            // O(1) check on third value
            numSet.contains(difference)
            // O(1) check for duplicates
            && ((difference != a && difference != b) || duplicates.contains(difference));
    }
}