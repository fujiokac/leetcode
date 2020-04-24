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

        // Tracking reversed nodes
        ListNode root = new ListNode(0);
        // Tracking start and end of k nodes
        ListNode top = root, tail = root;
        // Tracking original untouched nodes
        ListNode runner = head;

        boolean fullGroup = true;
        while (fullGroup) {
            // Check k nodes exist
            fullGroup = kNodesExist(runner, k);
            // First unreversed node
            ListNode a = runner;
            // Track end point
            tail = runner;

            // Swap k-1 nodes
            if (fullGroup) {
                ListNode b = a.next, c = null;
                for (int i = 0; i < k-1; i++) {
                    c = b.next;
                    b.next = a;
                    a = b;
                    b = c;
                }
                // Track next unreversed node
                runner = c;
            }

            // Attach nodes (reversed in case of fullGroup, untouched otherwise)
            top.next = a;

            // Move top to end of reversed nodes
            top = tail;
        }

        return root.next;
    }

    private boolean kNodesExist(ListNode node, final int k) {
        for (int i = 0; i < k; i++) {
            if (node == null) {
                return false;
            }
            node = node.next;
        }
        return true;
    }
}