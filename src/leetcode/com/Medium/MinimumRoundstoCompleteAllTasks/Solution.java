package leetcode.com.Medium.MinimumRoundstoCompleteAllTasks;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int minimumRounds(int[] tasks) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (final int task : tasks)
            count.merge(task, 1, Integer::sum);

        // Freq = 1 -> impossible
        // Freq = 2 -> needs 1 round
        // Freq = 3 -> needs 1 round
        // Freq = 3k                           -> needs k rounds
        // Freq = 3k + 1 = 3 * (k - 1) + 2 * 2 -> needs k + 1 rounds
        // Freq = 3k + 2 = 3 * k       + 2 * 1 -> needs k + 1 rounds
        for (final int freq : count.values())
            if (freq == 1)
                return -1;
            else
                ans += (freq + 2) / 3;

        return ans;
    }

    public static void main(String[] args) {
        int[] tasks = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};//Output: 4
        System.out.println(minimumRounds(tasks));
    }
}
