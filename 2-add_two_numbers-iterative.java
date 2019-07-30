/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
Exp
lanation: 342 + 465 = 807.
 * /
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // return addTwoH(l1, l2, false);
        int sum = 0, carry = 0;
        ListNode head = null;
        ListNode tail = null;

        while(l1 != null && l2 != null) {
            sum = carry;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum %= 10;

            ListNode result = new ListNode(sum);

            if(head == null) {
                head = result;
                tail = result;
            }
            else {
                tail.next = result;
                tail = tail.next;
            }

            if(l1 == null) {
                tail.next = finishSum(l2, carry == 1);
            }
            else if(l2 == null) {
                tail.next = finishSum(l1, carry == 1);
            }
        }

        return head;
    }

    public ListNode finishSum(ListNode node, boolean carry) {
        if(!carry) {
            return node;
        }
        if(node == null) {
            return new ListNode(1);
        }

        ListNode result = null;
        if (node.val < 9) {
            result = new ListNode(node.val + 1);
            result.next = node.next;
        }
        else {
            result = new ListNode(0);
            result.next = finishSum(node.next, true);
        }

        return result;
    }
}