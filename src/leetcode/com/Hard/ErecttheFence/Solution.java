package leetcode.com.Hard.ErecttheFence;

import java.util.*;

public class Solution {
    public static int[][] outerTrees(int[][] trees) {
        Stack<int[]> hull = new Stack<>();

        Arrays.sort(trees, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // Build lower hull: left-to-right scan
        for (int[] tree : trees) {
            while (hull.size() > 1 && cross(hull.peek(), hull.get(hull.size() - 2), tree) > 0)
                hull.pop();
            hull.push(tree);
        }
        hull.pop();

        // Build upper hull: right-to-left scan
        for (int i = trees.length - 1; i >= 0; --i) {
            while (hull.size() > 1 && cross(hull.peek(), hull.get(hull.size() - 2), trees[i]) > 0)
                hull.pop();
            hull.push(trees[i]);
        }

        // Remove redundant elements from the stack
        HashSet<int[]> unique = new HashSet<>(hull);
        return unique.toArray(new int[unique.size()][]);
    }

    private static int cross(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}}; //Output: [[1,1],[2,0],[3,3],[2,4],[4,2]]
        System.out.println(outerTrees(points));
    }
}
