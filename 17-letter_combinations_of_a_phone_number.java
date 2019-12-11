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
    public static final char[] TWO = new char[] {'a','b','c'};
    public static final char[] THREE = new char[] {'d','e','f'};
    public static final char[] FOUR = new char[] {'g','h','i'};
    public static final char[] FIVE = new char[] {'j','k','l'};
    public static final char[] SIX = new char[] {'m','n','o'};
    public static final char[] SEVEN = new char[] {'p','q','r','s'};
    public static final char[] EIGHT = new char[] {'t','u','v'};
    public static final char[] NINE = new char[] {'w','x','y','z'};
    public static final char[] EMPTY = new char[0];

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        digitCombos(digits, 0, new StringBuffer(), result);
        return result;
    }

    private void digitCombos(String digits, int index, StringBuffer sb, List<String> result) {
        if(index == digits.length()) {
            result.add(sb.toString());
        }
        else {
            for (char letter : digitToLetters(digits.charAt(index))) {
                sb.append(letter);
                digitCombos(digits, index+1, sb, result);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public char[] digitToLetters(char digit) {
        switch(digit) {
            case '2': return TWO;
            case '3': return THREE;
            case '4': return FOUR;
            case '5': return FIVE;
            case '6': return SIX;
            case '7': return SEVEN;
            case '8': return EIGHT;
            case '9': return NINE;
            default: return EMPTY;
        }
    }
}