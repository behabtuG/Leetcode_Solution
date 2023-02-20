package leetcode.com.Easy.UglyNumber;

public class Solution {
    public static boolean isUgly(int n) {
        if (n == 0)
            return false;

        for (final int prime : new int[]{2, 3, 5})
            while (n % prime == 0)
                n /= prime;

        return n == 1;
    }

    public static void main(String[] args) {
        int n = 14; //Output: false
        System.out.println(isUgly(n));
    }
}
