package leetcode.com.Medium.SingleElementinaSortedArray;

public class Solution {
    public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (m % 2 == 1)
                --m;
            if (nums[m] == nums[m + 1])
                l = m + 2;
            else
                r = m;
        }

        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 7, 7, 10, 11, 11};//Output: 10
        System.out.println(singleNonDuplicate(nums));
    }
}
