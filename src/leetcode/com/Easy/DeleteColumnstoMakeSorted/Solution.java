package leetcode.com.Easy.DeleteColumnstoMakeSorted;

public class Solution {
    public static int minDeletionSize(String[] strs) {
        final int n = strs[0].length();
        int ans = 0;
        for (int j = 0; j < n; j++)
            for (int i = 0; i + 1 < strs.length; ++i)
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    ++ans;
                    break;
                }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"cba", "daf", "ghi"};//Output: 1
        String[] strs0 = {"a", "b"};// Output: 0
        String[] strs1 = {"zyx", "wvu", "tsr"};//Output: 3
        System.out.println(minDeletionSize(strs));
        System.out.println(minDeletionSize(strs0));
        System.out.println(minDeletionSize(strs1));
    }
}
