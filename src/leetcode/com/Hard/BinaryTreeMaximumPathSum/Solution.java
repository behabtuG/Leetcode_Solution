package leetcode.com.Hard.BinaryTreeMaximumPathSum;

public class Solution {

    public static int maxPathSum(TreeNode root) {
        maxPathSumDownFrom(root);
        return ans;
    }

    private static int ans = Integer.MIN_VALUE;

    // root->val + 0/1 of its subtrees
    private static int maxPathSumDownFrom(TreeNode root) {
        if (root == null)
            return 0;

        final int l = Math.max(maxPathSumDownFrom(root.left), 0);
        final int r = Math.max(maxPathSumDownFrom(root.right), 0);
        ans = Math.max(ans, root.val + l + r);
        return root.val + Math.max(l, r);

    }

    public static void main(String[] args) {
        // Input: root = [-10,9,20,null,null,15,7]; //Output: 42
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode();
        root.left.right = new TreeNode();
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }
}
