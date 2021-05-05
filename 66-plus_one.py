class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        for i, d in enumerate(reversed(digits)):
            if d < 9:
                digits[-i-1] += 1;
                break
            digits[-i-1] = 0
            if i == len(digits) -1:
                digits.insert(0,1)
        return digits