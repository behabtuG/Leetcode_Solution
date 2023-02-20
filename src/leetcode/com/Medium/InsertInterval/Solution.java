package leetcode.com.Medium.InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        final int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int i = 0;

        while (i < n && intervals[i][1] < newInterval[0])
            ans.add(intervals[i++]);

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            ++i;
        }

        ans.add(newInterval);

        while (i < n)
            ans.add(intervals[i++]);

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};//Output: [[1,2],[3,10],[12,16]]
        System.out.println(Arrays.toString(Arrays.stream(insert(intervals, newInterval)).toArray()));
    }
}
