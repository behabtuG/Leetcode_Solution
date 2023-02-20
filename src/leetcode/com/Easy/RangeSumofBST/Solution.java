package leetcode.com.Easy.RangeSumofBST;

public class Solution {
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        if (root.val < low)
            return rangeSumBST(root.right, low, high);
        if (root.val > high)
            return rangeSumBST(root.left, low, high);
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public static void main(String[] args) {
        //Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10 //Output: 23
        TreeNode root = new TreeNode(10);
        int low = 6;
        int high = 10;

        System.out.println();

    }

}
