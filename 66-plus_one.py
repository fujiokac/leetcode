class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        for i, d in enumerate(reversed(digits)):
            if d == 9:
                digits[-i-1] = 0
            else:
                digits[-i-1] += 1;
                return digits
        return [1] + digits