package leetcode.com.Hard.OrderlyQueue;

import java.util.Arrays;

public class Solution {
    public static String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }

        String ans = s;

        for (int i = 1; i < s.length(); ++i) {
            String s2 = s.substring(i) + s.substring(0, i);
            if (ans.compareTo(s2) > 0)
                ans = s2;
        }

        return ans;

    }
    public static void main(String[] args){

        String s = "baaca"; int k = 3;//Output: "aaabc"

        System.out.println(orderlyQueue(s, k));}

}
