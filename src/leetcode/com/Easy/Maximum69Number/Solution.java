package leetcode.com.Easy.Maximum69Number;

public class Solution {

    public static int maximum69Number (int num) {
        char[] ans = String.valueOf(num).toCharArray();

        for (int i = 0; i < ans.length; ++i)
            if (ans[i] == '6') {
                ans[i] = '9';
                break;
            }

        return Integer.valueOf(String.valueOf(ans));
    }
    public static void main(String [] args){
        int num = 9669;//Output: 9969
        System.out.println(maximum69Number(num));
    }
}
