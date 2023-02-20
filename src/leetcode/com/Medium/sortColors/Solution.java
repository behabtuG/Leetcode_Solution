/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.Medium.sortColors;

/**
 *
 * @author GLORY
 */
////////////////////////////////////////////////////
/* Given an array nums with n objects colored red, white, or blue, sort them in place so that objects of 
 * the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library’s sort function.
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
////////////////////////////////////////////////////
public class Solution {

    public static void SortColors(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while (index <= end && start < end) {
            if (nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
                index++;
            } else if (nums[index] == 2) {
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            } else {
                index++;
            }
        }
        System.out.println(nums);
    }

    //public class news{
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        SortColors(nums);

    }
}
