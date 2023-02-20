package leetcode.com.Easy.LongestSubsequenceWithLimitedSum;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];
        Arrays.sort(nums);

        for (int i = 0; i < queries.length; ++i) {
            ans[i] = numofElementsLessThan(nums, queries[i]);

        }
        return ans;
    }

    private static int numofElementsLessThan(int[] nums, int query) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum > query)
                return i;
        }
        return nums.length;
    }


    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 1}, queries = {3, 10, 21}; //Output: [2,3,4]
        System.out.println(answerQueries(nums, queries).length);
    }
}
