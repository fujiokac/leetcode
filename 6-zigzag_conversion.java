import java.util.Map;
import java.util.HashMap;

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
        if(s.length() < 2) {
            return s;
        }
        if(numRows == 0) {
            return "";
        }
        if(numRows == 1) {
            return s;
        }
        // Common cases
        StringBuilder[] map = makeMap(s, numRows);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            if(map[i] != null) {
                sb.append(map[i].toString());
            }
        }
        return sb.toString();
    }
    /**
     * Iterate through the string O(n)
     * Determine row & add to Array of StringBuilder O(1)
     */
    public StringBuilder[] makeMap(String s, int numRows) {
        StringBuilder[] map = new StringBuilder[numRows];
        int modulo = 2*(numRows - 1);
        for(int i = 0; i < s.length(); i++) {
            int row = determineRow(i, modulo, numRows);
            if(map[row] == null) {
                map[row] = new StringBuilder();
            }
            map[row].append(s.charAt(i));
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
}