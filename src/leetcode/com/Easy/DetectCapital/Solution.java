package leetcode.com.Easy.DetectCapital;

public class Solution {
    public static boolean detectCapitalUse(String word) {
        return word.equals(word.toUpperCase()) ||
                word.substring(1).equals(word.substring(1).toLowerCase());
    }

    public static void main(String[] args) {
        String word = "USA";
        String word1 = "Ethiopia";
        String word2 ="addis ababa";
        String word3 ="Debere Markos";
        System.out.println(detectCapitalUse(word));
        System.out.println(detectCapitalUse(word1));
        System.out.println(detectCapitalUse(word2));
        System.out.println(detectCapitalUse(word3));
    }
}
