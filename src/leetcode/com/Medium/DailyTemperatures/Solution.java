package leetcode.com.Medium.DailyTemperatures;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>(); // Decreasing stack

        for (int i = 0; i < temperatures.length; ++i) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                final int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};  //Output: [1,1,4,2,1,1,0,0]
       // int[] temperatures = new int[];
        //temperatures.
         for (int i = 0; i < temperatures.length; i++)//for loop to print the array
            //System.out.print(a[i] + "");
            System.out.println(temperatures.toString().toString());
       // System.out.println(dailyTemperatures(new int[]{temperatures[i]}).toString());
    }
}
