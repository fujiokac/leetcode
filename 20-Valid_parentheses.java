/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.\
 * Note that an empty string is also considered valid.
 */

class Solution {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isClosed(c)) {
                if (stack.isEmpty() || !isPair(c, stack.pop())) {
                    return false;
                }
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean isClosed(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private boolean isPair(char close, char open) {
        switch(open) {
            case '(': return close == ')';
            case '[': return close == ']';
            case '{': return close == '}';
            default: return false;
        }
    }
}