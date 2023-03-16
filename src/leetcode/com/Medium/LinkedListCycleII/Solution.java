package leetcode.com.Medium.LinkedListCycleII;

public class Solution {
    public static ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        //Input: head = [1,2], pos = 0; //Output: tail connects to node index 0
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(detectCycle(head));
    }
}
