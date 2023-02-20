package leetcode.com.Medium.BitwiseANDofNumbersRange;

public class Solution {
    public static int rangeBitwiseAnd(int left, int right) {
        int shiftBits = 0;

        while (left != right) {
            left >>= 1;
            right >>= 1;
            ++shiftBits;
        }

        return left << shiftBits;
    }
    public static void main(String[] args){
       int left = 5, right = 7; //Output: 4
        System.out.println(rangeBitwiseAnd(left, right));
    }
}
