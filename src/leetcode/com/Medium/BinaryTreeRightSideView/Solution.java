package leetcode.com.Medium.BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private static void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (root == null)
            return;

        if (depth == ans.size())
            ans.add(root.val);
        dfs(root.right, depth + 1, ans);
        dfs(root.left, depth + 1, ans);
    }

    public static void main(String[] args) {
        // TreeNode  root = new TreeNode(new int[]{1, null, 3}); //Output: [1,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode();
        root.right = new TreeNode(3);
        System.out.println(rightSideView(root));
    }
}
