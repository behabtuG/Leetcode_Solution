package leetcode.com.Medium.NondecreasingSubsequences;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(nums, 0, new LinkedList<>(), ans);
        return ans;
    }

    private static void dfs(int[] nums, int s, LinkedList<Integer> path, List<List<Integer>> ans) {
        if (path.size() > 1)
            ans.add(new LinkedList<>(path));

        Set<Integer> used = new HashSet<>();

        for (int i = s; i < nums.length; ++i) {
            if (used.contains(nums[i]))
                continue;
            if (path.isEmpty() || nums[i] >= path.getLast()) {
                used.add(nums[i]);
                path.addLast(nums[i]);
                dfs(nums, i + 1, path, ans);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};//Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
        System.out.println(findSubsequences(nums));
    }
}
