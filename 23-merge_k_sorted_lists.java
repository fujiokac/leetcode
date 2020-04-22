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

        ListNode root = new ListNode(0);
        ListNode runner = root;

        int mIndex = -1;
        do {
            int minVal = Integer.MAX_VALUE;
            mIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                ListNode l = lists[i];

                if (l.val == runner.val && runner != root) {
                    mIndex = i;
                    break;
                }
                if (l.val < minVal) {
                    mIndex = i;
                    minVal = l.val;
                }
            }
            if (mIndex != -1) {
                runner.next = lists[mIndex];
                runner = runner.next;
                lists[mIndex] = lists[mIndex].next;
            }
        } while (mIndex != -1);

        return root.next;
    }
}