package leetcode.com.Medium.KokoEatingBananas;

import java.util.Arrays;

public class Solution {
    public static int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        while (l < r) {
            final int m = (l + r) / 2;
            if (eatHours(piles, m) <= h)
                r = m;
            else
                l = m + 1;
        }

        return l;
    }

    // Hours to eat all piles with speed m
    private static int eatHours(int[] piles, int m) {
        return Arrays.stream(piles).reduce(0, (subtotal, pile) -> subtotal + (pile - 1) / m + 1); // Math.ceil(pile / m)
    }

    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;//Output: 30
        System.out.println(minEatingSpeed(piles, h));
    }

}
