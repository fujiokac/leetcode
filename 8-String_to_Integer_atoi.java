import java.util.regex.*;
class Solution {
    public static final Pattern ATOI = Pattern.compile(" *([+-]?)0*(\\d+).*");
    public static final int MAX_LEN = 10;

    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }

        Matcher m = ATOI.matcher(str);
        if(!m.matches()) {
            return 0;
        }

        return atoiHelper("-".equals(m.group(1)), m.group(2));
    }

    private int atoiHelper(boolean negative, String str) {
        int maxInt = negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        if(str.length() > MAX_LEN) {
            return maxInt;
        }

        String compareStr = String.valueOf(maxInt);

        if(str.length() == MAX_LEN) {
            int compare = str.compareTo(negative ? compareStr.substring(1) : compareStr);
            if(compare >= 0) {
                return maxInt;
            }
        }
        return Integer.valueOf(str) * (negative ? -1 : 1);
    }
}