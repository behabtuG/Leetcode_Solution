package leetcode.com.Easy.BinaryTreePreorderTraversal;

import leetcode.com.Medium.CountCompleteTreeNodes.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    //Approach 1: Recursive
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    private static void preorder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;

        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

    //Approach 2: Iterative
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);
        }

        return ans;
    }

    public static void main(String[] args) {
        //TreeNode root = new int[]{1, 2, 3};//Output: [1,2,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode();
        root = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(preorderTraversal(root));
        System.out.println(preorderTraversal(root));
    }
}
