package leetcode.com.Easy.KthMissingPositiveNumber;

public class Solution {
    public static int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length;

        // Find the first index l s.t. nMissing(l) = A[l] - l - 1 >= k
        while (l < r) {
            final int m = (l + r) / 2;
            if (arr[m] - m - 1 >= k)
                r = m;
            else
                l = m + 1;
        }

        // The k-th missing positive
        // = A[l - 1] + k - nMissing(l - 1)
        // = A[l - 1] + k - (A[l - 1] - (l - 1) - 1)
        // = A[l - 1] + k - (A[l - 1] - l)
        // = l + k
        return l + k;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;//Output: 9
        System.out.println(findKthPositive(arr, k));
    }
}
