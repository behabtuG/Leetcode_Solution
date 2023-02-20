package leetcode.com.Medium.FlipStringtoMonotoneIncreasing;

public class Solution {
    public static int minFlipsMonoIncr(String S) {
        int[] dp = new int[2];

        for (int i = 0; i < S.length(); ++i) {
            int temp = dp[0] + (S.charAt(i) == '1' ? 1 : 0);
            dp[1] = Math.min(dp[0], dp[1]) + (S.charAt(i) == '0' ? 1 : 0);
            dp[0] = temp;
        }

        return Math.min(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        String s = "00011000";//Output: 2
        System.out.println(minFlipsMonoIncr(s));
    }

}
