class Solution {
    /**
     * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     */
     public int romanToInt(String s) {
        int num = 0;
        for(int i = 0, length = s.length() - 1; i <= length; i++) {
            int first = romanToInt(s.charAt(i));
            if(i < length) {
                int second = romanToInt(s.charAt(i + 1));
                if(first <= second) {
                    num += first < second ? second - first : first + second;
                    i++;
                    continue;
                }
            }
            num += first;
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