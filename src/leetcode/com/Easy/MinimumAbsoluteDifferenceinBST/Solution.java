package leetcode.com.Easy.MinimumAbsoluteDifferenceinBST;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    // Very similar to 94. Binary Tree Inorder Traversal
    public static int getMinimumDifference(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        int prev = -1;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev >= 0)
                ans = Math.min(ans, root.val - prev);
            prev = root.val;
            root = root.right;
        }

        return ans;
    }

    public static void main(String[] args) {
        // Input: root = [4,2,6,1,3]; Output: 1
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(getMinimumDifference(root));
    }
}