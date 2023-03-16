package leetcode.com.Medium.MinimumTimetoCompleteTrips;

import java.util.Arrays;

public class Solution {
    public static long minimumTime(int[] time, int totalTrips) {
        long l = 1;
        long r = Arrays.stream(time).min().getAsInt() * (long) totalTrips;

        while (l < r) {
            final long m = (l + r) / 2;
            if (numTrips(time, m) >= totalTrips)
                r = m;
            else
                l = m + 1;
        }

        return l;
    }

    private static long numTrips(int[] time, long m) {
        return Arrays.stream(time).asLongStream().reduce(0L, (subtotal, t) -> subtotal + m / t);
    }

    public static void main(String[] args) {

        int[] time = {1, 2, 3};
        int totalTrips = 5;//Output: 3
        System.out.println(minimumTime(time,totalTrips));
    }
}
