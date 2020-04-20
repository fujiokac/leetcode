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

        ListNode head = null;
        ListNode tail = null;

        // Both lists contain elements
        while (l1 != null && l2 != null) {
            int newVal;
            if (l1.val < l2.val) {
                newVal = l1.val;
                l1 = l1.next;
            }
            else {
                newVal = l2.val;
                l2 = l2.next;
            }

            ListNode node = new ListNode(newVal);
            if (head == null) {
               head = node;
               tail = node;
            }
            else {
                tail.next = node;
                tail = node;
            }
        }

        if (l1 == null) {
            tail.next = l2;
        }
        else {
            tail.next = l1;
        }

        return head;
    }
}