package leetcode.com.Easy.ShuffletheArray;

import java.util.Arrays;

public class Solution {
    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int j = 0;
        for (int i = 0; i < 2 * n; i = i + 2) {
            ans[i] = nums[j];
            ans[i + 1] = nums[n + j];
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;//Output: [2,3,5,4,1,7]
        System.out.println(Arrays.toString(shuffle(nums, n)));
    }
    //output: [2, 3, 5, 4, 1, 7]
}
