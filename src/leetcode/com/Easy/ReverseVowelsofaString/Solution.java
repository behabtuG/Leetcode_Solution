package leetcode.com.Easy.ReverseVowelsofaString;

public class Solution {
    public static String reverseVowels(String s) {
        final String vowels = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder(s);
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (l < r && !vowels.contains("" + sb.charAt(l)))
                ++l;
            while (l < r && !vowels.contains("" + sb.charAt(r)))
                --r;
            sb.setCharAt(l, s.charAt(r));
            sb.setCharAt(r, s.charAt(l));
            ++l;
            --r;
        }

        return sb.toString();
    }
    public static void main(String[] args){
        String S = "hello";//output holle
        System.out.println(reverseVowels(S));
    }
}
