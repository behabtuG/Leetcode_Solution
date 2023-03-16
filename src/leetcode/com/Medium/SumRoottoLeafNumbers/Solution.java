package leetcode.com.Medium.SumRoottoLeafNumbers;

public class Solution {
    public static int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private static int ans = 0;

    private static void dfs(TreeNode root, int path) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            ans += path * 10 + root.val;
            return;
        }

        dfs(root.left, path * 10 + root.val);
        dfs(root.right, path * 10 + root.val);
    }

    public static void main(String[] args) {
        //Input: root = [4,9,0,5,1]
        //Output: 1026
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sumNumbers(root));
    }
}
