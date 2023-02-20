package leetcode.com.Medium.MaximumBagsWithFullCapacityofRocks;

import java.util.Arrays;

public class Solution {
    public static int getMaxBags(int bagCapacity, int numBags, int numRocks) {
        // Calculate the maximum number of bags that can be filled to capacity
        int maxBags = numRocks / bagCapacity;
        // If there are any remaining rocks that cannot be evenly distributed among the bags, add an additional bag
        if (numRocks % bagCapacity != 0) {
            maxBags++;
        }
        // Return the maximum number of bags that can be filled to capacity, ensuring that it does not exceed the number of bags available
        return Math.min(maxBags, numBags);
    }

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        final int n = capacity.length;
        int[] diff = new int[n];

        for (int i = 0; i < n; ++i)
            diff[i] = capacity[i] - rocks[i];

        Arrays.sort(diff);

        for (int i = 0; i < n; ++i) {
            if (diff[i] > additionalRocks)
                return i;
            additionalRocks -= diff[i];
        }

        return n;
    }

    public static void main(String[] args) {
        // Test the getMaxBags function
        /**System.out.println(getMaxBags(5, 10, 50)); // Output: 10
         System.out.println(getMaxBags(5, 10, 51)); // Output: 11
         System.out.println(getMaxBags(5, 5, 25)); // Output: 5
         System.out.println(getMaxBags(5, 5, 26)); // Output: 6
         System.out.println(getMaxBags(10, 2, 10)); // Output: 3
         */
        int[] capacity = {2, 3, 4, 5}, rocks = {1, 2, 4, 4};
        int additionalRocks = 2; //Output: 3
        System.out.println(maximumBags(capacity, rocks, additionalRocks));
    }
}
