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
    public static final List<String> TWO = Arrays.asList("a","b","c");
    public static final List<String> THREE = Arrays.asList("d","e","f");
    public static final List<String> FOUR = Arrays.asList("g","h","i");
    public static final List<String> FIVE = Arrays.asList("j","k","l");
    public static final List<String> SIX = Arrays.asList("m","n","o");
    public static final List<String> SEVEN = Arrays.asList("p","q","r","s");
    public static final List<String> EIGHT = Arrays.asList("t","u","v");
    public static final List<String> NINE = Arrays.asList("w","x","y","z");
    public static final List<String> EMPTY = Collections.emptyList();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return EMPTY;
        }

        return digitCombos(digits);
    }

    private List<String> digitCombos(String digits) {
        char d = digits.charAt(0);

        List<String> result = new ArrayList<String>();
        List<String> letters = digitToLetters(d);

        if(digits.length() == 1) {
            result = letters;
        }
        else {
            for (String s : digitCombos(digits.substring(1))) {
                for (String letter : letters) {
                    result.add(letter + s);
                }
            }
        }
        return result;
    }

    public List<String> digitToLetters(char digit) {
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