package leetcode.com.Medium.HouseRobberII;

public class Solution {
    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private static int rob(int[] nums, int l, int r) {
        int prev1 = 0; // dp[i - 1]
        int prev2 = 0; // dp[i - 2]

        for (int i = l; i <= r; ++i) {
            final int dp = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = dp;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};  //Output: 4
        System.out.println(rob(nums));
    }
}
