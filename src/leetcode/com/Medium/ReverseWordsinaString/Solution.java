package leetcode.com.Medium.ReverseWordsinaString;

public class Solution {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s).reverse(); // Reverse the whole string
        reverseWords(sb, sb.length());                     // Reverse each word
        return cleanSpaces(sb, sb.length());               // Clean up spaces
    }

    private static void reverseWords(StringBuilder sb, int n) {
        int i = 0;
        int j = 0;

        while (i < n) {
            while (i < j || i < n && sb.charAt(i) == ' ') // Skip spaces
                ++i;
            while (j < i || j < n && sb.charAt(j) != ' ') // Skip non spaces
                ++j;
            reverse(sb, i, j - 1); // Reverse the word
        }
    }

    // Trim leading, trailing, and middle spaces
    private static String cleanSpaces(StringBuilder sb, int n) {
        int i = 0;
        int j = 0;

        while (j < n) {
            while (j < n && sb.charAt(j) == ' ') // Skip spaces
                ++j;
            while (j < n && sb.charAt(j) != ' ') // Keep non spaces
                sb.setCharAt(i++, sb.charAt(j++));
            while (j < n && sb.charAt(j) == ' ') // Skip spaces
                ++j;
            if (j < n) // Keep only one space
                sb.setCharAt(i++, ' ');
        }

        return sb.substring(0, i).toString();
    }

    private static void reverse(StringBuilder sb, int l, int r) {
        while (l < r) {
            final char temp = sb.charAt(l);
            sb.setCharAt(l++, sb.charAt(r));
            sb.setCharAt(r--, temp);
        }
    }

    public static void main(String[] args) {
        String s = "a good   example"; //Output: "example good a"
        System.out.println(reverseWords(s));
    }
}
