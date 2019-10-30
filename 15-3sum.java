/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 */
class Solution {
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

        HashSet<Integer> numSet = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(!numSet.add(nums[i])) {
                duplicates.add(nums[i]);
            }
        }

        return findTriplets(numSet, duplicates);
    }

    private List<List<Integer>> findTriplets(Set<Integer> numSet, Set<Integer> duplicates) {
        ArrayList<List<Integer>> triplets = new ArrayList<>();
        int[] sorted = numSet.stream().mapToInt(Number::intValue).sorted().toArray();
        for (Iterator<Integer> it = numSet.iterator(); it.hasNext();) {
            int first = it.next();
            for (int i = 0, j = sorted.length-1; j > i;) {
                if((first == sorted[i] || first == sorted[j]) && !duplicates.contains(first)) {
                    continue;
                }

                int sum = first + sorted[i] + sorted[j];

                if(sum == 0) {
                    triplets.add(Arrays.asList(first, sorted[i], sorted[j]));
                }
                else if(sum > 0) {
                    j--;
                }
                else if(sum < 0) {
                    i++;
                }
            }
        }

        return triplets;
    }
}