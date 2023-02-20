package leetcode.com.Medium.PerfectSquares;

import java.util.Arrays;

public class Solution {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n); // 1^2 x n

        dp[0] = 0; // No way
        dp[1] = 1; // 1^2

        for (int i = 2; i <= n; ++i)
            for (int j = 1; j * j <= i; ++j)
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;    //Output: 3 //Explanation: 12 = 4 + 4 + 4.
        System.out.println(numSquares(n));
    }
}
