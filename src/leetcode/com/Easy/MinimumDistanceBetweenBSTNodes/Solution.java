package leetcode.com.Easy.MinimumDistanceBetweenBSTNodes;

public class Solution {
    public static int minDiffInBST(TreeNode root) {
        inorder(root);
        return ans;
    }

    private static int ans = Integer.MAX_VALUE;
    private static Integer pred = null;

    private static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        if (pred != null)
            ans = Math.min(ans, root.val - pred);
        pred = root.val;
        inorder(root.right);
    }

    public static void main(String[] args) {

        //int[] root = {4,2,6,1,3};//Output: 1

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(minDiffInBST(root)); //output:1
    }
}
