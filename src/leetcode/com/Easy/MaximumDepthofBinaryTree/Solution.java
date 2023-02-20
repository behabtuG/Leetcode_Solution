package leetcode.com.Easy.MaximumDepthofBinaryTree;

public class Solution {
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        //Input: root = [3,9,20,null,null,15,7]; //Output: 3
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode();
        root.left.right = new TreeNode();
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));

    }
}
