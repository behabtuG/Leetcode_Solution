package leetcode.com.Easy.RemoveLinkedListElements;

public class Solution {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        for (; head != null; head = head.next)
            if (head.val != val) {
                prev.next = head;
                prev = prev.next;
            }
        prev.next = null; // In case the last val == val

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] head = {1, 2, 6, 3, 4, 5, 6};
        int val = 6; //Output: [1,2,3,4,5]
       // System.out.println(new ListNode(head, val));
    }
}
