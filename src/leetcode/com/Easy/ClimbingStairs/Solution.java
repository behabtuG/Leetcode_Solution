package leetcode.com.Easy.ClimbingStairs;

public class Solution {
    //Approach 1: 2D DP
    //Time: O(n)O(n)
    //Space: O(n)O(n)

    public static int climbStairs(int n) {
        // dp[i] := # of distinct ways to climb to i-th stair
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    //Approach 2: 1D DP
    // Time: O(n)O(n)
    //Space: O(1)O(1)
    public static int climbStairs2(int n) {
        int prev1 = 1; // dp[i - 1]
        int prev2 = 1; // dp[i - 2]
        for (int i = 2; i <= n; ++i) {
            final int dp = prev1 + prev2;
            prev2 = prev1;
            prev1 = dp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int n = 3;   //Output: 3
        System.out.println(climbStairs(n));
        System.out.println(climbStairs2(n));
    }
}
