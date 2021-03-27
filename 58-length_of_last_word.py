class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        # Given a string s consists of some words separated by spaces,
        # return the length of the last word in the string.
        # If the last word does not exist, return 0.

        # A word is a maximal substring consisting of non-space characters only.
        count = 0
        for i in range(0, len(s)):
            if s[-1 -i] == ' ':
                if count > 0:
                    break
            else:
                count += 1
        return count