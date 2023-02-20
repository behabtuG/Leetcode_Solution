package leetcode.com.Easy.GreatestCommonDivisorofStrings;

public class Solution {
    /**
     * public static String gcdOfStrings(String str1, String str2) {
     * if (str1.length() < str2.length())
     * return gcdOfStrings(str2, str1);
     * if (!str1.startsWith(str2))
     * return "";
     * if (str2.isEmpty())
     * return str1;
     * return gcdOfStrings(str2, mod(str1, str2));
     * }
     * <p>
     * private static String mod(String s1, final String s2) {
     * while (s1.startsWith(s2))
     * s1 = s1.substring(s2.length());
     * return s1;
     * }
     */
    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static String gcdOfStrings(String str1, String str2) {
        // Check if they have non-zero GCD string.
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Get the GCD of the two lengths.
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABC";//Output: "ABC"
        System.out.println(gcdOfStrings(str1, str2));
    }
}
