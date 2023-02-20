package leetcode.com.Medium.AllPathsFromSourcetoTarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>(Arrays.asList(0)), ans);
        return ans;
    }

    private static void dfs(int[][] graph, int u, List<Integer> path, List<List<Integer>> ans) {
        if (u == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (final int v : graph[u]) {
            path.add(v);
            dfs(graph, v, path, ans);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};//Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
        System.out.println(allPathsSourceTarget(graph));
    }
}
