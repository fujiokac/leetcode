/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode num1, ListNode num2) {
        return addTwoH(toList(num1),toList(num2));
    }

    /**
     * Insert nodes into arraylist for quick traversal
     */
    public List<ListNode> toList(ListNode node) {
        List<ListNode> l = new ArrayList<ListNode>();
        while(node != null) {
            l.add(node);
            node = node.next;
        }
        return l;
    }
    /**
     * Helper function for addTwoNumbers
     */
    public ListNode addTwoH(List<ListNode> num1, List<ListNode> num2) {
        int size1 = num1.size();
        int size2 = num2.size();

        ListNode head = null;
        // Iterate through arraylist, beginning at the end
        for(int index1 = size1-1, index2 = size2-1, carry = 0;
            // Continue loop in the case that any number hasn't been resolved, or a value is carried
            index1 >= 0 || index2 >= 0 || carry == 1; index1--, index2--) {
            // Init sum with carry value
            int sum = carry;
            // Add relevant digits to sum
            if(index1 >= 0) {
                sum += num1.get(index1).val;
            }
            if(index2 >= 0) {
                sum += num2.get(index2).val;
            }
            // Determine new carry values & init digit node
            carry = sum / 10;
            ListNode result = new ListNode(sum % 10);

            // Append new digit to linkedlist in reverse
            if(head == null) {
                head = result;
            }
            else {
                result.next = head;
                head = result;
            }
        }

        return head;
    }
}