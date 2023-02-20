package leetcode.com.Easy.LeafSimilarTrees;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public static void dfs(TreeNode node, List<Integer> leaves) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }

        dfs(node.left, leaves);
        dfs(node.right, leaves);
    }

    public static void main(String[] args) {
        //Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
        // Output: true
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(9);
        TreeNode n6 = new TreeNode(8);
        TreeNode n7 = new TreeNode();
        TreeNode n8 = new TreeNode();
        TreeNode n9 = new TreeNode(7);
        TreeNode n10 = new TreeNode(4);

        root.left = n1;
        root.right = n2;
        root.right.left = n3;
        root.right.right = n4;
        System.out.println(leafSimilar(root, root));
    }
}
