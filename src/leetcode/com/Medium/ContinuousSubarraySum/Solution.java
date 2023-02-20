/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.Medium.ContinuousSubarraySum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Glory
 */
public class Solution {

    public static boolean checkSubarraySum(int[] nums, int k) {
        int prefix = 0;
        Map<Integer, Integer> prefixToIndex = new HashMap<>();
        prefixToIndex.put(0, -1);

        for (int i = 0; i < nums.length; ++i) {
            prefix += nums[i];
            if (k != 0) {
                prefix %= k;
            }
            if (prefixToIndex.containsKey(prefix)) {
                if (i - prefixToIndex.get(prefix) > 1) {
                    return true;
                }
            } else {
                // Only add if absent, because the previous index is better
                prefixToIndex.put(prefix, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] behabtu = {23, 2, 6, 4, 7};
        int k = 13;
        System.out.println(checkSubarraySum(behabtu, k));
    }
}
