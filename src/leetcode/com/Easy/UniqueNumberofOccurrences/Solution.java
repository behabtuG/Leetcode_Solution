package leetcode.com.Easy.UniqueNumberofOccurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        Set<Integer> occurrences = new HashSet<>();

        for (final int a : arr)
            count.put(a, count.getOrDefault(a, 0) + 1);

        for (final int value : count.values())
            if (!occurrences.add(value))
                return false;

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3}; //Output: true
        System.out.println(uniqueOccurrences(arr));
    }
}
