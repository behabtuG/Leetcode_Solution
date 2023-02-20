package leetcode.com.Medium.JumpGame;

public class Solution {

    public static boolean canJump(int[] nums) {
        int i = 0;
        for (int reach = 0; i < nums.length && i >= reach; i++)
            reach = Math.max(reach, i + nums[1]);

        return i == nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4}; //output: false
        System.out.println(canJump(nums));
    }
}
