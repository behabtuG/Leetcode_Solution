package leetcode.com.Hard.FindMedianfromDataStream;

import java.util.*;

public class Solution {

   private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private Queue<Integer> minHeap = new PriorityQueue<>();

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);

        // Balance two heaps s.t.
        // |maxHeap| >= |minHeap| and |maxHeap| - |minHeap| <= 1
        if (maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
        else if (maxHeap.size() - minHeap.size() > 1)
            minHeap.offer(maxHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
        return (double) maxHeap.peek();
    }
    public static void main(String[] args){
        //Input
            //    ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]//[[], [1], [2], [], [3], []]
        //Output [null, null, null, 1.5, null, 2.0]
        //System.out.println(addNum());
    }
}
