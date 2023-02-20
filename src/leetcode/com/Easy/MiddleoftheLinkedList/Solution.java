package leetcode.com.Easy.MiddleoftheLinkedList;

public class Solution {
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // ListNode head = new ListNode({1, 2, 3, 4, 5, 6}); //Output: [4,5,6]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6); ////Output: [4,5,6]

        System.out.println(middleNode(head).val);
    }
}
