package leetcode.com.Medium.SingleThreadedCPU;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static int[] getOrder(int[][] tasks) {
        final int n = tasks.length;

        int[][] A = new int[n][3];

        for (int i = 0; i < n; ++i) {
            A[i][0] = tasks[i][0];
            A[i][1] = tasks[i][1];
            A[i][2] = i;
        }

        int[] ans = new int[n];
        int ansIndex = 0;
        Queue<T> minHeap = new PriorityQueue<>(
                (a, b) -> a.procTime == b.procTime ? a.index - b.index : a.procTime - b.procTime);
        int i = 0;     // tasks' pointer
        long time = 0; // Current time

        Arrays.sort(A, Comparator.comparing(a -> a[0]));

        while (i < n || !minHeap.isEmpty()) {
            if (minHeap.isEmpty())
                time = Math.max(time, (long) A[i][0]);
            while (i < n && time >= (long) A[i][0]) {
                minHeap.offer(new T(A[i][1], A[i][2]));
                ++i;
            }
            final int procTime = minHeap.peek().procTime;
            final int index = minHeap.poll().index;
            time += procTime;
            ans[ansIndex++] = index;
        }

        return ans;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(7);
        pq.add(10);
        pq.add(7);
        pq.add(12);
        pq.add(7);
        pq.add(5);
        pq.add(7);
        pq.add(4);
        pq.add(7);
        pq.add(2);

        int[][] tasks = {{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};//Output: [4,3,2,0,1]
        System.out.println(getOrder(tasks));
    }
}
