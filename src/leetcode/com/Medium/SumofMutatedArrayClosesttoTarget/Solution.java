package leetcode.com.Medium.SumofMutatedArrayClosesttoTarget;

import java.util.Arrays;

public class Solution {
    public static int findBestValue(int[] arr, int target) {

        int len = arr.length;
        Arrays.sort(arr);
        int l = 0;
        while (l < len && arr[l] * (len - l) < target) {
            target -= arr[l];
            l++;
        }
        if (l == len) {
            return arr[len - 1];
        }
        int size = len - l;
        int avg = target / size;
        int t = avg * size;
        //t + size = (avg + 1) * size
        return t + size - target < target - t ? avg + 1 : avg;
    }

    public static void main(String[] args) {
        int[] arr = {4, 9, 3};
        int target = 10; //Output: 3
        System.out.println(findBestValue(arr, target));
    }
}
