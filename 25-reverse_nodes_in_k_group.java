/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, final int k) {
        if (head == null || k < 2) {
            return head;
        }

        // Check k nodes exist
        ListNode runner = head;
        for (int i = 0; i < k; i++) {
            if (runner == null) {
                return head;
            }
            runner = runner.next;
        }

        // Swap k-1 nodes
        ListNode a = head, b = head.next, c = null;
        for (int i = 0; i < k-1; i++) {
            c = b.next;
            b.next = a;
            a = b;
            b = c;
        }

        // Append tail
        head.next = reverseKGroup(c, k);

        // Return new head
        return a;
    }
}