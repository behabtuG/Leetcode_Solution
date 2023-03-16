package leetcode.com.Medium.ConstructBinaryTreefromInorderandPostorderTraversal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inToIndex = new HashMap<>();

        for (int i = 0; i < inorder.length; ++i)
            inToIndex.put(inorder[i], i);

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1,
                inToIndex);
    }

    static TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
                          Map<Integer, Integer> inToIndex) {
        if (inStart > inEnd)
            return null;

        final int rootVal = postorder[postEnd];
        final int rootInIndex = inToIndex.get(rootVal);
        final int leftSize = rootInIndex - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, inStart, rootInIndex - 1, postorder, postStart,
                postStart + leftSize - 1, inToIndex);
        root.right = build(inorder, rootInIndex + 1, inEnd, postorder, postStart + leftSize,
                postEnd - 1, inToIndex);
        return root;
    }

    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7}, postorder = {9, 15, 7, 20, 3};// Output: [3,9,20,null,null,15,7]

        System.out.println(buildTree(inorder, postorder).toString());

        //output:
    }

}
