class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }

        boolean isNegative = false;
        boolean hasStarted = false;

        int number = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                if(!hasStarted) {
                    if(c == ' ') {
                        continue;
                    }
                    isNegative = c == '-';
                    if(isNegative || c == '+') {
                        hasStarted = true;
                        continue;
                    }
                }
                break;
            }

            if (!hasStarted) {
                hasStarted = true;
            }

            int digit = c - '0';
            if ((Integer.MAX_VALUE - digit) / 10 < number) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            number *= 10;
            number += digit;
        }

        return isNegative ? -number : number;
    }
}