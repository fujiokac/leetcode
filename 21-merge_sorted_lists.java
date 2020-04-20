/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Both lists are empty
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // Root & runner nodes
        ListNode root = new ListNode(0);
        ListNode a = l1, b = l2, current = root;

        // Both lists contain elements
        while (a != null && b != null) {
            if (a.val < b.val) {
                current.next = a;
                a = a.next;
            }
            else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }

        // Completing list with remaining list
        current.next = a == null ? b : a;

        return root.next;
    }
}