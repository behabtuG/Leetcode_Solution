package leetcode.com.Medium.CheckCompletenessofaBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));

        while (q.peek() != null) {
            TreeNode node = q.poll();
            q.offer(node.left);
            q.offer(node.right);
        }

        while (!q.isEmpty() && q.peek() == null)
            q.poll();

        return q.isEmpty();
    }

    public static void main(String[] args) {
        //Input: root = [1,2,3,4,5,6]
        // Output: true
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
    System.out.println(isCompleteTree(root));
    }
}
