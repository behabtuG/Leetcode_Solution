package leetcode.com.Easy.SearchInsertPosition;

public class Solution {
    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            final int m = (l + r) / 2;
            if (nums[m] == target)
                return m;
            if (nums[m] < target)
                l = m + 1;
            else
                r = m;
        }

        return l;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;//Output: 2
        System.out.println(searchInsert(nums, target));
    }
}
