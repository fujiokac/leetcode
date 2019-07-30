/**
 * Given a Binary Search Tree and a target number,
 * return true if there exist two elements in the BST
 * such that their sum is equal to the given target.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return searchNodes(root, root, k);
    }

    /**
     * Preorder DFS node search
     */
    public boolean searchNodes(TreeNode root, TreeNode current, int k) {
        if(current == null) {
            return false;
        }
        return pairSearch(root, current, k - current.val)
            || searchNodes(root, current.left, k)
            || searchNodes(root, current.right, k);
    }

    /**
     * Binary search for complement of root.val
     */
    public boolean pairSearch(TreeNode root, TreeNode current, int value) {
        if(root == null) {
            return false;
        }

        return (root.val == value && root != current)
            || (root.val < value && pairSearch(root.right, current, value))
            || (root.val > value && pairSearch(root.left, current, value));
    }
}