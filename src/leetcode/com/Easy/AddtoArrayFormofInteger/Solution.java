package leetcode.com.Easy.AddtoArrayFormofInteger;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new LinkedList<>();

        for (int i = num.length - 1; i >= 0; --i) {
            ans.add(0, (num[i] + k) % 10);
            k = (num[i] + k) / 10;
        }

        while (k > 0) {
            ans.add(0, k % 10);
            k /= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 0, 0};
        int k = 34;//Output: [1,2,3,4] Explanation: 1200 + 34 = 1234
        System.out.println(addToArrayForm(num,k));
    }
}
