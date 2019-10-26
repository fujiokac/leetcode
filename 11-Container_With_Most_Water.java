class Solution {
    public int maxArea(int[] height) {
        // Smallest possible case
        if(height.length == 2) {
            return Math.min(height[0], height[1]);
        }
        // Track current maximum area
        int max = 0;
        // Two pointer solution O(n)
        for(int a = 0, b = height.length -1; a < b;) {
            // Determine max at current pointers
            max = Math.max(max, (b - a) * Math.min(height[a], height[b]));

            // Iterate through array until one of the following:
            // 1. height larger than smallest height
            // 2. all heights checked
            if(height[a] > height[b]) {
                for(int compare = height[b]; a < b && height[b] <= compare; b--);
            }
            else {
                for(int compare = height[a]; a < b && height[a] <= compare; a++);
            }
        }

        return max;
    }
}