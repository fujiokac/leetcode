class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }

        str = str.trim();
        boolean isNegative = false;

        if(str.length() != 0 && !Character.isDigit(str.charAt(0))) {
            isNegative = str.charAt(0) == '-';
            if(isNegative || str.charAt(0) == '+') {
                str = str.substring(1);
            }
        }

        int number = 0;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                break;
            }

            int digit = str.charAt(i) - '0';
            if ((Integer.MAX_VALUE - digit) / 10 < number) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            number *= 10;
            number += digit;
        }

        return isNegative ? -number : number;
    }
}