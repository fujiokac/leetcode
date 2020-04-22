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

        List<ListNode> nodes = new ArrayList<>();
        Set<Integer> emptyLists = new HashSet<>();
        while (emptyLists.size() < lists.length) {
            for (int i = 0; i < lists.length; i++) {
                if (emptyLists.contains(i)) continue;
                if (lists[i] == null) {
                    emptyLists.add(i);
                    continue;
                }

                nodes.add(lists[i]);
                lists[i] = lists[i].next;

            }
        }

        if (nodes.isEmpty()) {
            return null;
        }

        Collections.sort(nodes, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode n1, ListNode n2) {
				return n1.val - n2.val;
			}
		});

        ListNode root = new ListNode(0);
        ListNode runner = root;

		for (ListNode node : nodes) {
		    runner.next = node;
		    runner = runner.next;
		}

        return root.next;
    }
}