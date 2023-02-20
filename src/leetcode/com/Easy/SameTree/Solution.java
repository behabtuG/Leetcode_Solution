package leetcode.com.Easy.SameTree;

public class Solution {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        return p.val == q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(1);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(2);
        q.left = new TreeNode(1);
        q.right = new TreeNode(3);
        System.out.println(isSameTree(p, q));

    }
}
