/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * 2: abc
 * 3: def
 * 4: ghi
 * 5: jkl
 * 6: mno
 * 7: pqrs
 * 8: tuv
 * 9: wxyz
*/
class Solution {
    public static final char[][] LETTERS = new char[][] {
        {'a','b','c'},
        {'d','e','f'},
        {'g','h','i'},
        {'j','k','l'},
        {'m','n','o'},
        {'p','q','r','s'},
        {'t','u','v'},
        {'w','x','y','z'}
    };


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        digitCombos(digits, 0, new char[digits.length()], result);
        return result;
    }
    /**
     * Recursive helper function
     */
    private void digitCombos(String digits, int index, char[] buffer, List<String> result) {
        if(index < digits.length()) {
            // Iterate through letters mapped to digit at current index of string
            for (char letter : LETTERS[digits.charAt(index) - '2']) {
                // Store letter temporarily in buffer
                buffer[index] = letter;
                // Recursive call on next digit
                digitCombos(digits, index+1, buffer, result);
            }
        }
        else {
            // End of string, convert buffer to String & add to result
            result.add(String.valueOf(buffer));
        }
    }
}