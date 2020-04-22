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

        List<ListNode> nodes = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                nodes.add(node);
                node = node.next;
            }

        }

        Collections.sort(nodes, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode n1, ListNode n2) {
				return n1.val - n2.val;
			}
		});

		for (ListNode node : nodes) {
		    runner.next = node;
		    runner = runner.next;
		}

        return root.next;
    }
}