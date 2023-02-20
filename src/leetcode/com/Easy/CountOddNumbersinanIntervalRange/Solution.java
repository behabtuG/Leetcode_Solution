package leetcode.com.Easy.CountOddNumbersinanIntervalRange;

public class Solution {
    public static int countOdds(int low, int high) {
        return (high + 1) / 2 - low / 2;
    }

    public static void main(String[] args) {
        int low = 3, high = 7;//Output: 3  Explanation: The odd numbers between 3 and 7 are [3,5,7].
        System.out.println(countOdds(low, high));
    }
}
