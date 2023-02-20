package leetcode.com.Medium.DominoandTrominoTiling;

public class Solution {
    public static int numTilings(int N) {
        final int kMod = 1_000_000_007;

        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i <= N; i++)
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % kMod;
        return (int) dp[N];
    }

    public static void main(String[] args) {
        int N = 3;
        System.out.println(numTilings(N));//5
    }
}
