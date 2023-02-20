package leetcode.com.Easy.InvertBinaryTree;


public class Solution {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public static void main(String[] args) {
        // Input: root = [4,2,7,1,3,6,9];Output: [4,7,2,9,6,3,1]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(invertTree(root).toString());
    }
}
