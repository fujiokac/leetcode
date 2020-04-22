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

        PriorityQueue<ListNode> nodes = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode n1, ListNode n2) {
				return n1.val - n2.val;
			}
		});

        for (ListNode node : lists) {
            if (node != null) {
                nodes.add(node);
            }
        }

        if (nodes.isEmpty()) {
            return null;
        }

        ListNode root = new ListNode(0);
        ListNode runner = root;

		while (!nodes.isEmpty()) {
		    runner.next = nodes.poll();
		    runner = runner.next;
		    if (runner.next != null) {
		        nodes.add(runner.next);
		    }
		}

        return root.next;
    }
}