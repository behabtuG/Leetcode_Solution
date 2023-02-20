package leetcode.com.Hard.ShortestPalindrome;

public class Solution {
    public static String shortestPalindrome(String s) {
        final String t = new StringBuilder(s).reverse().toString();

        for (int i = 0; i < t.length(); ++i)
            if (s.startsWith(t.substring(i)))
                return t.substring(0, i) + s;

        return t + s;
    }

    public static void main(String[] args) {
        String s = "aacecaaa";  //Output: "aaacecaaa"
        System.out.println(shortestPalindrome(s));
    }
}
