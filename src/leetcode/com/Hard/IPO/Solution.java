package leetcode.com.Hard.IPO;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Queue<T> minHeap = new PriorityQueue<>((a, b) -> a.cap - b.cap);
        Queue<T> maxHeap = new PriorityQueue<>((a, b) -> b.pro - a.pro);

        for (int i = 0; i < Capital.length; ++i)
            minHeap.offer(new T(Profits[i], Capital[i]));

        while (k-- > 0) {
            while (!minHeap.isEmpty() && minHeap.peek().cap <= W)
                maxHeap.offer(minHeap.poll());
            if (maxHeap.isEmpty())
                break;
            W += maxHeap.poll().pro;
        }

        return W;
    }
}

class T {
    public int pro;
    public int cap;

    public T(int pro, int cap) {
        this.pro = pro;
        this.cap = cap;
    }

    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = {1, 2, 3}, capital = {0, 1, 1};//Output: 4
        System.out.println(Solution.findMaximizedCapital(k, w, profits, capital));
    }
}
