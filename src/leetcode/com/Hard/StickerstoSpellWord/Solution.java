package leetcode.com.Hard.StickerstoSpellWord;

import java.util.Arrays;

public class Solution {
    public static int minStickers(String[] stickers, String target) {
        final int n = target.length();
        final int maxMask = 1 << n;
        int[] dp = new int[maxMask];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int mask = 0; mask < maxMask; ++mask) {
            if (dp[mask] == Integer.MAX_VALUE)
                continue;
            for (final String sticker : stickers) {
                int superMask = mask;
                for (final char c : sticker.toCharArray())
                    for (int i = 0; i < n; ++i)
                        if (c == target.charAt(i) && (superMask >> i & 1) == 0) {
                            superMask |= 1 << i;
                            break;
                        }
                dp[superMask] = Math.min(dp[superMask], dp[mask] + 1);
            }
        }

        return dp[maxMask - 1] == Integer.MAX_VALUE ? -1 : dp[maxMask - 1];
    }

    public static void main(String[] args) {
        String[] stickers = {"with", "example", "science"};
        String target = "thehat"; //Output: 3
        ///String[] stickers = {"notice", "possible"};
        //  String target = "basicbasic"; //Output: -1
        System.out.println(minStickers(stickers, target));
    }

}
