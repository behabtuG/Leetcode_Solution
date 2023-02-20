package leetcode.com.Medium.PossibleBipartition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    enum Color {kWhite, kRed, kGreen}

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n + 1];
        Color[] colors = new Color[n + 1];
        Arrays.fill(colors, Color.kWhite);

        for (int i = 1; i <= n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] d : dislikes) {
            final int u = d[0];
            final int v = d[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        // Reduce to 785. Is Graph Bipartite?
        for (int i = 1; i <= n; ++i)
            if (colors[i] == Color.kWhite && !isValidColor(graph, i, colors, Color.kRed))
                return false;

        return true;
    }

    private static boolean isValidColor(List<Integer>[] graph, int u, Color[] colors, Color color) {
        // The painted color should be same as the `color`
        if (colors[u] != Color.kWhite)
            return colors[u] == color;

        colors[u] = color; // Always paint w/ `color`

        // All children should have valid colors
        for (final int v : graph[u])
            if (!isValidColor(graph, v, colors, color == Color.kRed ? Color.kGreen : Color.kRed))
                return false;

        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        System.out.println(possibleBipartition(n, dislikes));//Output: false
    }
}
