/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * Given a linked list, remove the n-th node from the end of list and return its head
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note: Given n will always be valid.
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) {
            return null;
        }

        ListNode root = new ListNode(0);
        root.next = head;

        ListNode current = root;
        ListNode nAhead = root;

        for (int i = 0; i < n; i++) {
            nAhead = nAhead.next;
        }

        while (nAhead.next != null) {
            current = current.next;
            nAhead = nAhead.next;
        }

        current.next = current.next.next;

        return root.next;
    }
}