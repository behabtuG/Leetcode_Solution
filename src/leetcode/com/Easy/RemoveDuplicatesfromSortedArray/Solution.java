package leetcode.com.Easy.RemoveDuplicatesfromSortedArray;

import leetcode.com.Hard.FindMedianfromDataStream.MedianFinder;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0

        for (final int num : nums)
            if (i < 1 || num > nums[i - 1])
                nums[i++] = num;

        return i;
    }
   public static void main(String[] args){
      int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};//Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
      System.out.println(removeDuplicates(nums));
   }
}
