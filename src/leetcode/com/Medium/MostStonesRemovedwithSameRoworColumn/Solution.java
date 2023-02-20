package leetcode.com.Medium.MostStonesRemovedwithSameRoworColumn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static int removeStones(int[][] stones) {
        int numOfIslands = 0;
        List<Integer>[] graph = new List[stones.length];
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < graph.length; ++i)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < stones.length; ++i)
            for (int j = i + 1; j < stones.length; ++j)
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    graph[i].add(j);
                    graph[j].add(i);
                }

        for (int i = 0; i < stones.length; ++i)
            if (seen.add(i)) {
                dfs(graph, i, seen);
                ++numOfIslands;
            }

        return stones.length - numOfIslands;
    }

    private static void dfs(List<Integer>[] graph, int u, Set<Integer> seen) {
        for (final int v : graph[u])
            if (seen.add(v))
                dfs(graph, v, seen);
    }
    public static void main(String[] args){
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2, 2}};//Output: 5
        System.out.println(removeStones(stones));
    }
}
