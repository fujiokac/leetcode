class Solution {
    /**
     * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     */
    public int romanToInt(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        int previous = romanToInt(s.charAt(0));
        int num = previous;
        for(int i = 1; i < s.length(); i++) {
            int current = romanToInt(s.charAt(i));
            num += current;
            if(previous < current) {
                num -= 2 * previous;
            }
            previous = current;
        }
        return num;
    }

    private int romanToInt(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}