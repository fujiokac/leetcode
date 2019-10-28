class Solution {
    /**
     * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
     */
    public static String[] M = {"", "M", "MM", "MMM"};
    public static String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    public static String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    public static String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int num) {
        return M[num / 1000].concat(C[num % 1000 / 100]).concat(X[num % 100 / 10]).concat(I[num % 10]);
    }
}