/**
 * Given the root of a binary tree with N nodes,
 * each node in the tree has node.val coins, and there are N coins total.
 *
 * In one move, we may choose two adjacent nodes and move one coin from one node to another.
 * (The move may be from parent to child, or from child to parent.)
 *
 * Return the number of moves required to make every node have exactly one coin.
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
    private int actions = 0;
    public int distributeCoins(TreeNode root) {
        // Base case (empty node)
        if(root == null) {
            return 0;
        }

        // Recursive case
        distribute(root);

        return actions;

    }

    /**
     * Functioning concept:
     * It does not matter if the parent node "currently" has the resources to fill the child nodes
     * That action will have to be taken eventually, thus the required actions can be derived
     * by a DFS accumulation of credits & debits.
     */
    public int distribute(TreeNode root) {
        // End of branch
        if(root == null) {
            return 0;
        }
        // Each node requires one coin, remainders need to be distributed
        int difference = root.val - 1;
        // No children
        if(root.left == null && root.right == null) {
            return difference;
        }
        // Determine how many coins children need
        int left = distribute(root.left);
        int right = distribute(root.right);
        // Update class member actions with actions required to distribute to children
        actions += Math.abs(left) + Math.abs(right);
        // Return amount of coins required by node to fulfill all needs within subtree.
        return difference + left + right;
    }
}