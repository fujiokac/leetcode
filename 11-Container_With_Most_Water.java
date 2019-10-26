class Solution {
    public int maxArea(int[] height) {
        if(height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        int max = 0;
        for(int a = 0, b = height.length -1; a < b;) {
            max = Math.max(max, (b - a) * Math.min(height[a], height[b]));

            if(height[a] > height[b]) {
                b--;
            }
            else {
                a++;
            }
        }
        return max;
    }
}