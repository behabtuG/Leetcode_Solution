/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.Medium.NumberofDiceRollsWithTargetSum;

/**
 *
 * @author Glory
 */
public class Soution {

    public static int numRollsToTarget(int n, int k, int target) {
        final int kMod = 1_000_000_007;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        while (n-- > 0) { // N dices
            int[] newDp = new int[target + 1];
            for (int i = 1; i <= k; ++i) // Number 1, 2, ..., f
            {
                for (int t = i; t <= target; ++t) { // Possible targets
                    newDp[t] += dp[t - i];
                    newDp[t] %= kMod;
                }
            }
            dp = newDp;
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int n = 30;
        int k = 30;
        int target = 500;
        System.out.println(numRollsToTarget(n, k, target));
    }
}
