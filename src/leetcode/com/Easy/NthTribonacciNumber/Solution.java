package leetcode.com.Easy.NthTribonacciNumber;

public class Solution {
    public static int tribonacci(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, c = 1, d;
        while (n-- > 2) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    public static void main(String[] args) {
       // int n = 4;
        int n = 12;
        int ans = tribonacci(n);
        System.out.println(ans);
    }

    //Explanation: As zeroth, first ,and second tribonacci numbers are 0,1,1 respectively. So the third tribonacci number is (0+1+1) 2.
    // Likewise, the fourth tribonacci is (1+1+2) 4.
}
