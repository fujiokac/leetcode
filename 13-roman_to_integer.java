class Solution {
    /**
     * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     */

     public static enum Roman {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        private final int value;

        Roman (final int aValue) {
            value = aValue;
        }

        public int getValue() {
            return value;
        }
    }

     public int romanToInt(String str) {
        int num = 0;
        Roman[] arr = str.chars()
                .mapToObj(c -> Roman.valueOf(String.valueOf((char) c)))
                .toArray(Roman[]::new);
        for(int i = 0, length = arr.length - 1; i <= length; i++) {
            if(i < length) {
                int next = i+1;
                int compare = arr[i].compareTo(arr[next]);
                if(compare <= 0) {
                    num += compare < 0 ? arr[next].getValue() - arr[i].getValue() : 2 * arr[i].getValue();
                    i++;
                    continue;
                }
            }
            num += arr[i].getValue();
        }
        return num;
    }
}