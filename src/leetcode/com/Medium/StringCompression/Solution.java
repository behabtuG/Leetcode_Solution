package leetcode.com.Medium.StringCompression;

public class Solution {
    public static int compress(char[] chars) {
        int ans = 0;

        for (int i = 0; i < chars.length; ) {
            final char letter = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == letter) {
                ++count;
                ++i;
            }
            chars[ans++] = letter;
            if (count > 1)
                for (final char c : String.valueOf(count).toCharArray())
                    chars[ans++] = c;
        }

        return ans;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        //Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
        System.out.println(compress(chars));
    }
}
