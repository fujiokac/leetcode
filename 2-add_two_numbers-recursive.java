/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode num1, ListNode num2) {
        return addTwoH(num1, num2, false);
    }

    /**
     * Helper function for addTwoNumbers
     */
    public ListNode addTwoH(ListNode num1, ListNode num2, boolean carry) {
        // Base Case: both numbers empty, check for carried value
        if(num1 == null && num2 == null) {
            return carry ? new ListNode(1) : null;
        }
        // One number has terminated, call addOneH
        if(num1 == null) {
            return carry ? addOneH(num2, carry) : num2;
        }
        if(num2 == null) {
            return carry ? addOneH(num1, carry) : num1;
        }

        // Both numbers still contain values
        int sum = num1.val + num2.val + (carry ? 1 : 0);
        ListNode result = new ListNode(sum % 10);
        // Recursive call for next digit place
        result.next = addTwoH(num1.next, num2.next, sum > 9);
        return result;
    }

    /**
     * Helper function for completing calculation on larger number
     */
    public ListNode addOneH(ListNode num, boolean carry) {
        // Base Case: Number has no value, check for carried value
        if(num == null) {
            return carry ? new ListNode(1) : null;
        }
        // Number has value
        int sum = num.val + (carry ? 1 : 0);
        ListNode result = new ListNode(sum % 10);
        carry = sum > 9;
        // Recursive call in the case of a carry, otherwise chain nodes from original value
        result.next = carry ? addOneH(num.next, carry) : num.next;
        return result;
    }
}