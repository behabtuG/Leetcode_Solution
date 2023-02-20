package leetcode.com.Medium.KeysandRooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Solution {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] seen = new int[rooms.size()];
        dfs(rooms, 0, seen);
        return Arrays.stream(seen).allMatch(a -> a == 1);
    }

    private static void dfs(List<List<Integer>> rooms, int node, int[] seen) {
        seen[node] = 1;
        for (final int child : rooms.get(node))
            if (seen[child] == 0)
                dfs(rooms, child, seen);
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<List<Integer>>();
        ArrayList<Integer> listInner = new ArrayList<>();
        listInner.add(1);
        listInner.add(2);
        listInner.add(3);
        listInner.add(null);
        rooms.add(listInner);

        System.out.println(canVisitAllRooms(rooms)); //Output: true
    }

}
