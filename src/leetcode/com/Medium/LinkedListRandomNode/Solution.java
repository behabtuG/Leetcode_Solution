package leetcode.com.Medium.LinkedListRandomNode;

import java.util.Random;

public class Solution {
    /**
     * @param head The linked list's head. Note that the head is guaranteed to be
     *             not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int ans = -1;
        int i = 1;

        for (ListNode curr = head; curr != null; curr = curr.next, ++i)
            if (rand.nextInt(i) == i - 1)
                ans = curr.val;

        return ans;
    }

    private ListNode head;
    private Random rand = new Random();

    public static void main(String[] args) {

        //Solution solution = new Solution(1, 2, 3);
        // solution.getRandom(); // return 1
        //solution.getRandom(); // return 3
        //solution.getRandom(); // return 2
        //solution.getRandom(); // return 2
        //solution.getRandom(); // return 3
    }
}
