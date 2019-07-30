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
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode tail = null;
        boolean end1 = list1 == null;
        boolean end2 = list2 == null;
        boolean carry = false;

        // While lists are not empty or a carry is being completed
        while(carry || !(end1 || end2)) {
            int sum = carry ? 1 : 0;
            // Add values to sum and increment listnodes
            if(!end1) {
                sum += list1.val;
                list1 = list1.next;
                end1 = list1 == null;
            }
            if(!end2) {
                sum += list2.val;
                list2 = list2.next;
                end2 = list2 == null;
            }

            // Determine carry & remainder
            carry = sum > 9;
            if(carry) {
                sum -= 10;
            }

            ListNode result = new ListNode(sum);

            // Establish/increment result LL
            if(head == null) {
                head = result;
                tail = result;
            }
            else {
                tail.next = result;
                tail = tail.next;
            }
            // If no values to carry, fill in result with remaining list nodes
            if(!carry) {
                if(end1) {
                    result.next = list2;
                }
                else if(end2) {
                    result.next = list1;
                }
            }
        }
        // Done
        return head;
    }
}