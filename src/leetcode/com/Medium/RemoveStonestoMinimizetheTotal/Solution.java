package leetcode.com.Medium.RemoveStonestoMinimizetheTotal;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> descendingQueue = new PriorityQueue<>(Collections.reverseOrder());
        //PriorityQueue<Integer> descendingQueue = new PriorityQueue<>((a, b) -> b - a); can also used

        int sum = 0;
        int newValue;
        int currentValue;
        int half;
        for (int stones : piles) {
            sum += stones;
            descendingQueue.offer(stones);
        }
        while (k > 0) {
            currentValue = descendingQueue.poll();//removing the highest element
            half = currentValue / 2;
            newValue = currentValue - half;
            descendingQueue.offer(newValue);//add the remainder value to queue
            sum -= half;
            k--;
        }
        return sum;
    }

    public static int minStonesSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        //(a, b) -> b - a is a lambda expression b/c we want maximum heap or priority Queue. so maximum value in the top
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            pq.add(piles[i]); // element
            //System.out.println(pq);
        }
        int t = 0;
        while (t < k) {
            int c = pq.poll();//removing the highest element
            int r = Math.floorDiv(c, 2);//

            pq.offer(c - r);//add the remainder value to queue again

            t++;
            while (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] piles = {5, 4, 9};
        int k = 2; //Output: 12
        System.out.println(minStoneSum(piles, k));
        //System.out.println(minStonesSum(piles, k));
    }

}
