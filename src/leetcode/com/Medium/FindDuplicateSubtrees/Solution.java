package leetcode.com.Medium.FindDuplicateSubtrees;

import java.util.*;

public class Solution {
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        encode(root, count, ans);
        return ans;
    }

    private static String encode(TreeNode root, Map<String, Integer> count, List<TreeNode> ans) {
        if (root == null)
            return "";

        final String encoded =
                root.val + "#" + encode(root.left, count, ans) + "#" + encode(root.right, count, ans);
        count.merge(encoded, 1, Integer::sum);
        if (count.get(encoded) == 2)
            ans.add(root);
        return encoded;
    }

    public static void main(String[] args) {
        //Input: root = [1,2,3,4,null,2,4,null,null,4]
        // Output: [[2,4],[4]]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode();
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode();
        root.left.left.right = new TreeNode();
        root.right.left.left = new TreeNode(4);
        System.out.println(findDuplicateSubtrees(root));

    }
}
