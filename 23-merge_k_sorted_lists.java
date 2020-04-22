/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return mergeLists(lists, 0, lists.length);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        int length = end - start;
        if (length == 1) {
            return lists[start];
        }
        if (length == 2) {
            return mergeTwoLists(lists[start], lists[end-1]);
        }
        int mid = start + length/2;
        return mergeTwoLists(
            mergeLists(lists, start, mid),
            mergeLists(lists, mid, end));
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        // Both lists are empty
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        // Root & runner nodes
        ListNode root = new ListNode(0);
        ListNode runner = root;

        // Both lists contain elements
        while (a != null && b != null) {
            if (a.val < b.val) {
                runner.next = a;
                a = a.next;
            }
            else {
                runner.next = b;
                b = b.next;
            }
            runner = runner.next;
        }

        // Completing list with remaining list
        runner.next = a == null ? b : a;

        return root.next;
    }
}