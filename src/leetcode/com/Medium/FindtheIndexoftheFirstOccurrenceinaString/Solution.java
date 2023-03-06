package leetcode.com.Medium.FindtheIndexoftheFirstOccurrenceinaString;

public class Solution {
    public static int strStr(String haystack, String needle) {
        final int m = haystack.length();
        final int n = needle.length();

        for (int i = 0; i < m - n + 1; ++i)
            if (haystack.substring(i, i + n).equals(needle))
                return i;

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";//Output: 0
        System.out.println(strStr(haystack,needle));
    }
}
