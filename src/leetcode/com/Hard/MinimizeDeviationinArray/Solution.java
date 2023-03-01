package leetcode.com.Hard.MinimizeDeviationinArray;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution {
    public static int minimumDeviation(int[] nums) {
        int currMinimum = Integer.MAX_VALUE;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            if (num % 2 != 0) {
                num *= 2;
            }
            currMinimum = Math.min(currMinimum, num);
            priorityQueue.add(num);
        }
        int deviation = Integer.MAX_VALUE;
        while (priorityQueue.peek() % 2 == 0) {
            int removed = priorityQueue.poll() / 2;
            currMinimum = Math.min(currMinimum, removed);
            priorityQueue.add(removed);
            deviation = Math.min(deviation, priorityQueue.peek() - currMinimum);
        }
        return deviation;
    }
    public static int minimumDeviation1(int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int num : nums) {
            if (num % 2 == 1)
                set.add(num * 2);
            else
                set.add(num);
        }
        int minDeviation = set.last() - set.first();
        while (minDeviation > 0 && set.last() % 2 == 0) {
            int max = set.last();
            set.remove(max);
            set.add(max / 2);
            minDeviation = Math.min(minDeviation, set.last() - set.first());
        }
        return minDeviation;
    }
    public static void main(String[] args) {
        int[] nums = {4, 1, 5, 20, 3};//Output: 3
        System.out.println(minimumDeviation(nums));
        System.out.println(minimumDeviation1(nums));
    }
}
