package leetcode.com.Medium.SumofSubarrayMinimums;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public static int sumSubarrayMins(int[] arr) {
        final int kMod = 1_000_000_007;
        final int n = arr.length;
        long ans = 0;
        int[] prev = new int[n];
        int[] next = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        Arrays.fill(prev, -1);
        Arrays.fill(next, n);

        for (int i = 0; i < arr.length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                final int index = stack.pop();
                next[index] = i;
            }
            if (!stack.isEmpty())
                prev[i] = stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < arr.length; ++i) {
            ans += (long) arr[i] * (i - prev[i]) * (next[i] - i);
            ans %= kMod;
        }

        return (int) ans;
    }
    public static void main(String[] args){
       int[] arr = {3,1,2,4};  //Output: 17
        System.out.println(sumSubarrayMins(arr));
    }

}
