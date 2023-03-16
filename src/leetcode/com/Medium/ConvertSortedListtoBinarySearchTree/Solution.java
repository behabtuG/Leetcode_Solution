package leetcode.com.Medium.ConvertSortedListtoBinarySearchTree;

import java.util.Arrays;

public class Solution {
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);

        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    private static ListNode findMid(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        return slow;

    }

    public static void main(String[] args) {
        //Input: head = [-10,-3,0,5,9]
        // Output: [0,-3,9,-10,null,5];
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        //head.left = new TreeNode(-3);
        // head.right = new TreeNode(9);
        // head.left.left = new TreeNode(-10);
        // head.right.left = new TreeNode(9);
        System.out.println(sortedListToBST(head).toString());
    }
}