package leetcode.com.Easy.ContainsDuplicateII;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; ++i) {
            if (!seen.add(nums[i]))
                return true;
            if (i >= k)
                seen.remove(nums[i - k]);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3; //Output: true
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
