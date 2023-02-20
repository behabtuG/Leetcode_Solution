package leetcode.com.Easy.BinaryTreePostorderTraversal;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Solution {
    // Approach 1: Recursive

    //Time: O(n)O(n)
    //Space: O(h)O(h)
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }

    private static void postorder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;

        //postorder(root.left, ans);
        //postorder(root.right, ans);
        //ans.add(root.val);
    }

    //Approach 2: Iterative

    // Time: O(n)O(n)
    //Space: O(h)O(h)
    public static List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        /**while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);
            if (root.left != null)
                stack.push(root.left);
            if (root.right != null)
                stack.push(root.right);
        }
*/
        Collections.reverse(ans);
        return ans;
    }

}
