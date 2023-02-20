package leetcode.com.Hard.DataStreamasDisjointIntervals;

import java.util.Map;
import java.util.TreeMap;


public class SummaryRanges {

    private TreeMap<Integer, Integer> startToEndIntervals;

    public SummaryRanges() {
        startToEndIntervals = new TreeMap<>();
    }

    public void addNum(int value) {
        Map.Entry<Integer, Integer> closestBefore = startToEndIntervals.floorEntry(value);
        if (closestBefore != null && value >= closestBefore.getKey() && value <= closestBefore.getValue()) {
            return;
        }
        Map.Entry<Integer, Integer> closestAfter = startToEndIntervals.ceilingEntry(value);

        int min = value;
        int max = value;
        if (closestBefore != null && closestBefore.getValue() + 1 == value) {
            startToEndIntervals.remove(closestBefore.getKey());
            min = closestBefore.getKey();
        }
        if (closestAfter != null && closestAfter.getValue() - 1 == value) {
            startToEndIntervals.remove(closestAfter.getKey());
            max = closestAfter.getKey();
        }
        startToEndIntervals.put(min, max);
    }

    public int[][] getIntervals() {
        int intervals[][] = new int[startToEndIntervals.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : startToEndIntervals.entrySet()) {
            intervals[i++] = new int[]{entry.getKey(), entry.getValue()};
        }
        return intervals;
    }


    /**
     * Your SummaryRanges object will be instantiated and called as such:
     * SummaryRanges obj = new SummaryRanges();
     * obj.addNum(value);
     * int[][] param_2 = obj.getIntervals();
     */

    public static void main(String[] args) {
        String[] Input = {"SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals",
                "addNum", "getIntervals", "addNum", "getIntervals"};// {{}, {1}, {}, {3}, {}, {7}, {}, {2}, {}, {6},{}};
        SummaryRanges obj = new SummaryRanges();
        obj.addNum(1);
        obj.addNum(3);
        obj.addNum(7);
        obj.addNum(2);
        obj.addNum(6);
        //List<Interval> result = obj.getIntervals();
        // for (Interval interval : result) {
        // System.out.println(interval.start + " " + interval.end);
    }
}




