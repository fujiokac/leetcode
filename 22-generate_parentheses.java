/**
 * Given n pairs of parentheses, write a function to
 * generate all combinations of well-formed parentheses.
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }

        List<String> combinations = new ArrayList<>();
        char[] comb = new char[n*2];
        generateCombinations(0, 0, 0, comb, combinations);
        return combinations;
    }

    private void generateCombinations(int index, int openParens, int totalParens, char[] comb, List<String> combinations) {
        if (index < comb.length) {
            if (totalParens < comb.length) {
                comb[index] = '(';
                generateCombinations(index + 1, openParens + 1, totalParens + 2, comb, combinations);
            }

            if(openParens > 0) {
                comb[index] = ')';
                generateCombinations(index + 1, openParens - 1, totalParens, comb, combinations);
            }
        }
        else {
            combinations.add(String.valueOf(comb));
        }
    }
}