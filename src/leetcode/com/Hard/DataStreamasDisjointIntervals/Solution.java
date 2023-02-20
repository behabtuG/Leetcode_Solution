package leetcode.com.Hard.DataStreamasDisjointIntervals;

import java.util.*;

public class Solution {

    public void addNum(int val) {
        if (map.containsKey(val))
            return;

        final Integer lo = map.lowerKey(val);  // Maximum in map < key
        final Integer hi = map.higherKey(val); // Minimum in map > key

        // {lo, map.get(lo)[1]} + val + {hi, map.get(hi)[1]} = {lo, map.get(hi)[1]}
        if (lo != null && hi != null && map.get(lo)[1] + 1 == val && val + 1 == hi) {
            map.get(lo)[1] = map.get(hi)[1];
            map.remove(hi);
            // {lo, map.get(lo)[1]} + val = {lo, val}
            // (prevent adding duplicate entry by using '>=' instead of '==')
        } else if (lo != null && map.get(lo)[1] + 1 >= val) {
            map.get(lo)[1] = Math.max(map.get(lo)[1], val);
            // Val + {hi, map.get(hi)[1]} = {val, map.get(hi)[1]}
        } else if (hi != null && val + 1 == hi) {
            map.put(val, new int[]{val, map.get(hi)[1]});
            map.remove(hi);
        } else {
            map.put(val, new int[]{val, val});
        }
    }

    public int[][] getIntervals() {
        List<int[]> intervals = new ArrayList<>(map.values());
        return intervals.toArray(new int[intervals.size()][]);
    }

    // {start: {start, end}}
    private TreeMap<Integer, int[]> map = new TreeMap<>();


    /**
     * Your SummaryRanges object will be instantiated and called as such:
     * SummaryRanges obj = new SummaryRanges();
     * obj.addNum(value);
     * int[][] param_2 = obj.getIntervals();
     */

    //String[] Input = {"SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals",
    // "addNum", "getIntervals", "addNum", "getIntervals"};// {{}, {1}, {}, {3}, {}, {7}, {}, {2}, {}, {6},{}};
    //Output [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]],
    // null, [[1, 3], [6, 7]]]
    // System.out.println();
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[][] param_1 = obj.getIntervals();
        System.out.println(Arrays.deepToString(param_1)); // should output "[]"

        obj.addNum(1);
        param_1 = obj.getIntervals();
        System.out.println(Arrays.deepToString(param_1)); // should output "[[1, 1]]"

        obj.addNum(3);
        param_1 = obj.getIntervals();
        System.out.println(Arrays.deepToString(param_1)); // should output "[[1, 1], [3, 3]]"

        obj.addNum(7);
        param_1 = obj.getIntervals();
        System.out.println(Arrays.deepToString(param_1)); // should output "[[1, 1], [3, 3], [7, 7]]"

        obj.addNum(2);
        param_1 = obj.getIntervals();
        System.out.println(Arrays.deepToString(param_1)); // should output "[[1, 3], [7, 7]]"

        obj.addNum(6);
        param_1 = obj.getIntervals();
        System.out.println(Arrays.deepToString(param_1)); // should output "[[1, 3], [6, 7]]"
    }

}
