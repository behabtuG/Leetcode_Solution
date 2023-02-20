/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.Medium.wiggleSort;

/**
 *
 * @author GLORY
 */
public class wiggleSort {

    public void wiggleSort(int[] nums) {
        //public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // Swap cases: nums[i] < nums[i - 1] for odd numbers or nums[i] > nums[i - 1] for even numbers
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                int tmp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = tmp;
            }
        }
    }
    public static void main(String[] args) {
      int [] nums = {};
        System.out.println();
    }
}
