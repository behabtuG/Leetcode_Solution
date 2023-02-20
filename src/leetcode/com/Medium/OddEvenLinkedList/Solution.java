package leetcode.com.Medium.OddEvenLinkedList;

public class Solution {
    public static ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode odd = oddHead;
        ListNode even = evenHead;

        for (boolean isOdd = true; head != null; head = head.next, isOdd = !isOdd)
            if (isOdd) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }

        odd.next = evenHead.next;
        even.next = null;
        return oddHead.next;
    }

    public static void main(String[] args) {
        //Input: head = [2,1,3,5,6,4,7];//Output: [2,3,6,7,1,5,4]
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println(oddEvenList(head).val);
    }
}
