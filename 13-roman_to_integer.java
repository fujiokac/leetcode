class Solution {
    /**
     * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     */
    public int romanToInt(String s) {
        // Naive solution
        int num = 0;
        for(int i = 0, j = 1, length = s.length(); i < length; i++) {
            char c = s.charAt(i);
            j = i + 1;
            switch(c) {
                case 'M':
                    num += 1000;
                    break;
                case 'C':
                    if(j < length) {
                        char next = s.charAt(j);
                        if(next == 'M') {
                            num += 900;
                            i++;
                            break;
                        }
                        else if(next == 'D') {
                            num += 400;
                            i++;
                            break;
                        }
                    }
                    num += 100;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'X':
                    if(j < length) {
                        char next = s.charAt(j);
                        if(next == 'C') {
                            num += 90;
                            i++;
                            break;
                        }
                        else if(next == 'L') {
                            num += 40;
                            i++;
                            break;
                        }
                    }
                    num += 10;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'I':
                    if(j < length) {
                        char next = s.charAt(j);
                        if(next == 'X') {
                            num += 9;
                            i++;
                            break;
                        }
                        else if(next == 'V') {
                            num += 4;
                            i++;
                            break;
                        }
                    }
                    num++;
                    break;
                case 'V':
                    num += 5;
                    break;
            }
        }
        return num;
    }
}