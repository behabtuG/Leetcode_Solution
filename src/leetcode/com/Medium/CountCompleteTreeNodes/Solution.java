package leetcode.com.Medium.CountCompleteTreeNodes;

//import javax.swing.tree.TreeNode;

public class Solution {
    //Approach 1: Naive

    // Time: O(n)O(n)
    //Space: O(h)O(h)

    public static int countNodes(TreeNode root) {

        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    //Approach 2: Heuristic

    //Time: O(log⁡2n)O(log2nzzz)
    //Space: O(h)O(h)

    /**
     * public static int countNodes(TreeNode root) {
     * if (root == null)
     * return 0;
     * <p>
     * TreeNode l = root;
     * TreeNode r = root;
     * int heightL = 0;
     * int heightR = 0;
     * <p>
     * while (l != null) {
     * ++heightL;
     * l = l.left;
     * }
     * <p>
     * while (r != null) {
     * ++heightR;
     * r = r.right;
     * }
     * <p>
     * if (heightL == heightR) // Root is a complete tree
     * return (int) Math.pow(2, heightL) - 1;
     * return 1 + countNodes(root.left) + countNodes(root.right);
     * }
     */
    public static void main(String[] args) {
        //int[] root = new int[]{1, 2, 3, 4, 5, 6};//Output: 6
        // create an object of BinaryTree
        TreeNode root = new TreeNode(1);
        //create nodes of the tree
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(countNodes(root));
    }
}
