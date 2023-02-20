package leetcode.com.Medium.MinimumTimetoCollectAllApplesinaTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        return dfs(graph, 0, new boolean[n], hasApple);
    }

    private static int dfs(List<Integer>[] graph, int u, boolean[] seen, List<Boolean> hasApple) {
        seen[u] = true;
        int totalCost = 0;

        for (final int v : graph[u]) {
            if (seen[v])
                continue;
            final int cost = dfs(graph, v, seen, hasApple);
            if (cost > 0 || hasApple.get(v))
                totalCost += cost + 2;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, false, true, false);//Output: 6
        System.out.println(minTime(n, edges, hasApple));
    }
}
