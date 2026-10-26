/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> visited = new LinkedList<>();
        ArrayList<Integer> nodes = new ArrayList<>();
        if (root == null) {
            return result;
        } 
        // else if (root.left == null && root.right == null) {
        //     nodes.add(root.val);
        //     result.add(nodes);
        //     return result;
        // }

        visited.add(root);
    
        while (!visited.isEmpty()) {
            int levelSize = visited.size();
            nodes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = visited.remove();
                nodes.add(curr.val);
                if (curr.left != null) {
                    visited.add(curr.left);
                }
                if (curr.right != null) {
                    visited.add(curr.right);
                }
            }
            result.add(nodes);
        }
        return result;
    }
}
