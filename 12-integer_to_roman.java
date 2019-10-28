class Solution {
    /**
     * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
     */
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        // Naive solution
        while(num > 0) {
            if(num >= 1000) {
                roman.append('M');
                num -= 1000;
            }
            else if(num >= 900) {
                roman.append("CM");
                num -= 900;
            }
            else if(num >= 500) {
                roman.append('D');
                num -= 500;
            }
            else if(num >= 400) {
                roman.append("CD");
                num -= 400;
            }
            else if(num >= 100) {
                roman.append('C');
                num -= 100;
            }
            else if(num >= 90) {
                roman.append("XC");
                num -= 90;
            }
            else if(num >= 50) {
                roman.append('L');
                num -= 50;
            }
            else if(num >= 40) {
                roman.append("XL");
                num -= 40;
            }
            else if(num >= 10) {
                roman.append('X');
                num -= 10;
            }
            else if(num == 9) {
                roman.append("IX");
                num -= 9;
            }
            else if(num >= 5) {
                roman.append('V');
                num -= 5;
            }
            else if(num == 4) {
                roman.append("IV");
                num = 0;
            }
            else {
                roman.append('I');
                num--;
            }
        }

        return roman.toString();
    }
}