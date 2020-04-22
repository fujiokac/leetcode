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

        return mergeLists(lists);
    }

    private ListNode mergeLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }
        int mid = lists.length/2;
        return mergeTwoLists(
            mergeLists(Arrays.copyOfRange(lists, 0, mid)),
            mergeLists(Arrays.copyOfRange(lists, mid, lists.length)));
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