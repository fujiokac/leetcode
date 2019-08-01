import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution(args);
    }

    public Solution(String[] args) {
        System.out.println(convert(args[0], Integer.valueOf(args[1])));
    }
    /**
     * Make map and unfold rows into one string as return value O(n)
     */
    public String convert(String s, int numRows) {
        // Edge Cases
        if(s.length() <= numRows || numRows == 1) {
            return s;
        }
        if(numRows == 0) {
            return "";
        }
        // Common cases
        return String.valueOf(sortLetters(s, numRows));
    }
    /**
     * Iterate through the string O(n)
     * Determine row & add to array of char O(1)
     */
    public char[] sortLetters(String s, int numRows) {
        int len = s.length();
        int modulo = 2*(numRows - 1);
        char[] map = new char[len];
        int[] index = indexArray(len, modulo, numRows);
        // System.out.println(Arrays.toString(index));
        for(int i = 0; i < len; i++) {
            int row = determineRow(i, modulo, numRows);
            // System.out.println(String.format("%d %d %d",i,row,index[row]));
            map[index[row]++] = s.charAt(i);
        }
        return map;
    }
    /**
     * Formula by which row is assigned O(1):
     * modulo = 2 * (numRows - 1)
     * row = i % modulo OR modulo - (i % modulo)
     */
    public int determineRow(int i, int modulo, int numRows) {
        int row = i%modulo;
        if(row >= numRows) {
            row = modulo - row;
        }
        return row;
    }
    /**
     * Initialize array of indices where:
     * arr[row] = starting index of each row in final string
     * To be applied to charArray[length]
     */
    public int[] indexArray(int length, int modulo, int numRows) {
        int[] indexArray = new int[numRows];
        int reps = length / modulo;
        int remainder = length % modulo;
        int index = 0;
        for(int row = 1; row < numRows; row++) {
            // The formula for the starting index of each row
            index += (row > 1 ? 2 : 1)*reps;
            if(remainder > 0) {
                index++;
                remainder--;
            }
            if(remainder > 2*(numRows - row)-1) {
                index++;
                remainder--;
            }

            indexArray[row] = index;
        }
        return indexArray;
    }
}